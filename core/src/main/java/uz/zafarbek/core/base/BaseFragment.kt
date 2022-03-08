package uz.zafarbek.core.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.addCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavDirections
import androidx.navigation.Navigator
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.zafarbek.core.utils.ktx.getScreenWH

abstract class BaseFragment : Fragment {

    lateinit var ctx: Context
    lateinit var act: Activity

    var screenWidth = 0
    var screenHeight = 0

    abstract val viewModel: BaseViewModel

    constructor() : super()
    constructor(contentLayoutId: Int) : super(contentLayoutId)


    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
        act = requireActivity()
        val point = ctx.getScreenWH()
        screenWidth = point.x
        screenHeight = point.y
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            launch {
                collectFlow()
            }
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.showErrorMessage.collect { message ->
                        Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show()
                    }
                }
                launch {
                    viewModel.navigationCommand.collect { command ->
                        navigate(command.direction, command.navExtras)
                    }
                }
                launch {
                    viewModel.showLoading.collect { isLoading ->

                    }
                }
                launch {
                    viewModel.back.collect {
                        findNavController().popBackStack()
                    }
                }
            }
        }
    }

    open suspend fun collectFlow() {}

    fun navigate(direction: NavDirections, navExtras: Navigator.Extras? = null) =
        with(findNavController()) {
            currentDestination?.getAction(direction.actionId)?.let {
                if (navExtras == null)
                    navigate(direction)
                else
                    navigate(direction, navExtras)
            }
        }

    fun color(color: Int) = ContextCompat.getColor(ctx, color)

    protected fun onBackPressed(onBack: () -> Boolean) {
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner) {
                if (!onBack()) activity?.finish()
            }
    }

    protected fun navigateToBack() {
        findNavController().popBackStack()
    }
}
package uz.zafarbek.main.ui.fragments

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.zafarbek.core.base.BaseFragment
import uz.zafarbek.core.utils.ktx.OnActionListener
import uz.zafarbek.core.utils.ktx.errorToast
import uz.zafarbek.core.utils.ktx.successToast
import uz.zafarbek.domain.data.ui.Information
import uz.zafarbek.domain.data.ui.Test
import uz.zafarbek.domain.data.ui.Topic
import uz.zafarbek.main.R
import uz.zafarbek.main.databinding.FragmentTestBinding
import uz.zafarbek.main.ui.vm.MainViewModel
import kotlin.properties.Delegates

@AndroidEntryPoint
class TestFragment : BaseFragment(R.layout.fragment_test) {

    override val viewModel: MainViewModel by viewModels()
    private val binding: FragmentTestBinding by viewBinding()
    private lateinit var topic: Topic
    private var onNextClickListener: OnActionListener<Boolean>? = null
    private var t by Delegates.notNull<Int>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getTopicTests(topic.id)
        binding.next.setOnClickListener {
                if (t== binding. variants.checkedRadioButtonId){
                    successToast("Correct!!")
                    onNextClickListener?.onAction(true)
                }else{
                    errorToast("Wrong")
                }
            }
        }

    private val testObserver = Observer<List<Test>> { test ->
        test.map {
            binding.question.text = it.question
        }
        with(binding) {
            test.map { it.variants.forEachIndexed { index, s ->
                if (s==it.correct){
                    t=index
                }
                variants.addView(RadioButton(context).apply {
                    buttonTintList =
                        ColorStateList.valueOf(resources.getColor(uz.zafarbek.core.R.color.next_1))
                    id = index
                    text = s
                })
            } }

            variants.setOnCheckedChangeListener { _, checkedId ->

            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.testState.observe(viewLifecycleOwner, testObserver)
    }

    companion object {
        fun instance(topic: Topic, onActionListener: OnActionListener<Boolean>?) = TestFragment().apply {
            this.topic = topic
            this.onNextClickListener = onActionListener
        }
    }
}

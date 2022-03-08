package uz.zafarbek.main.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.zafarbek.core.base.BaseFragment
import uz.zafarbek.core.utils.ktx.OnActionListener
import uz.zafarbek.domain.data.ui.Topic
import uz.zafarbek.main.R
import uz.zafarbek.main.databinding.FragmentTeachingBinding
import uz.zafarbek.main.ui.adapter.TeachingPagerAdapter
import uz.zafarbek.main.ui.vm.MainViewModel


@AndroidEntryPoint
class TeachingFragment : BaseFragment(R.layout.fragment_teaching) {

    override val viewModel: MainViewModel by viewModels()
    private val binding: FragmentTeachingBinding by viewBinding()
    private val args by navArgs<TeachingFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getSectionTopics(args.sectionId)
//        binding.stepView.done(true)
        binding.stepView.state
            .animationDuration(resources.getInteger(android.R.integer.config_shortAnimTime))
            .commit()
    }

    private val topicsObserver = Observer<List<Topic>> {
        setPager(it)
        if(!it.isNullOrEmpty()){
            binding.stepView.setStepsNumber(it.size)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.topicState.observe(viewLifecycleOwner, topicsObserver)
    }

    private fun setPager(data: List<Topic>) {
        with(binding.pager) {
            adapter = TeachingPagerAdapter(
                this@TeachingFragment,
                data = data
            ).apply {
                onNextClicked = OnActionListener {
                    binding.pager.currentItem = binding.pager.currentItem + 1
                }
            }

            registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    binding.stepView.go(position,true)
                }
            })
        }
//        binding.indicator.stepCount=data.size
    }
}
package uz.zafarbek.main.ui.fragments

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.annotation.RawRes
import androidx.core.view.isGone
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import uz.zafarbek.core.base.BaseFragment
import uz.zafarbek.core.utils.ktx.OnActionListener
import uz.zafarbek.domain.data.ui.Information
import uz.zafarbek.domain.data.ui.Topic
import uz.zafarbek.main.R
import uz.zafarbek.main.databinding.FragmentInformationBinding
import uz.zafarbek.main.ui.adapter.InformationAdapter
import uz.zafarbek.main.ui.vm.MainViewModel


@AndroidEntryPoint
class InformationFragment : BaseFragment(R.layout.fragment_information) {

    override val viewModel: MainViewModel by viewModels()
    private val adapter = InformationAdapter()
    private val binding: FragmentInformationBinding by viewBinding()
    private lateinit var topic: Topic
    private var informations: List<Information> = listOf()
    private var onNextClickListener: OnActionListener<Boolean>? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getTopicInformation(topic.id)
        binding.recycler.adapter = adapter
        Glide.with(requireContext()).load(topic.image).into(binding.image)
        var mediaPlayer: MediaPlayer = MediaPlayer()
        binding.next.isGone = true
        binding.tapContinue.setOnClickListener {
            if (adapter.currentList.size < informations.size) {
                val item = informations[adapter.currentList.size]
                adapter.submitList(
                    adapter.currentList + listOf(item)
                )
                val afd = requireContext().resources.openRawResourceFd(item.audio)
                if (afd != null) {
                    mediaPlayer.reset()
                    mediaPlayer.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                    afd.close()
                    mediaPlayer.prepare()
                    mediaPlayer.start()
                }
            }
            if (adapter.currentList.size == informations.size) {
                binding.tapContinue.isGone = true
                binding.next.isGone = false
            } else {
                binding.tapContinue.isGone = false
                binding.next.isGone = true
            }
        }

        binding.next.setOnClickListener {
            onNextClickListener?.onAction(true)
        }
    }

    private val informationObserver = Observer<List<Information>> {
        informations = it
    }

    override fun onResume() {
        super.onResume()
        viewModel.informationState.observe(viewLifecycleOwner, informationObserver)
    }


    companion object {
        fun instance(topic: Topic, onActionListener: OnActionListener<Boolean>?) =
            InformationFragment().apply {
                this.topic = topic
                this.onNextClickListener = onActionListener
            }
    }
}
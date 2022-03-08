package uz.zafarbek.main.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.text.HtmlCompat
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.zafarbek.core.base.BaseFragment
import uz.zafarbek.main.R
import uz.zafarbek.main.databinding.FragmentDescriptionBinding
import uz.zafarbek.main.ui.enums.HomeType
import uz.zafarbek.main.ui.vm.MainViewModel

@AndroidEntryPoint
class DescriptionFragment : BaseFragment(R.layout.fragment_description) {

    override val viewModel: MainViewModel by viewModels()
    private lateinit var type: HomeType
    private val binding: FragmentDescriptionBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val htmlText:String = "<h2>What is Android?</h2>\n" + "<p>Android is an open source and Linux-based <b>Operating System</b> for mobile devices such as smartphones and tablet computers.Android was developed by the <i>Open Handset Alliance</i>, led by Google, and other companies.</p>\n" + "<p>Android offers a unified approach to application development for mobile devices which means developers need only develop for Android, and their applications should be able to run on different devices powered by Android.</p>\n" + "<p>The first beta version of the Android Software Development Kit (SDK) was released by Google in 2007 whereas the first commercial version, Android 1.0, was released in September 2008.</p>";
        binding.text.text=HtmlCompat.fromHtml(htmlText,0)
    }



    companion object {
        fun instance(type: HomeType) = DescriptionFragment().apply {
            this.type = type
        }
    }
}
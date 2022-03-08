package uz.zafarbek.main.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.zafarbek.core.utils.ktx.OnActionListener
import uz.zafarbek.domain.data.ui.Course
import uz.zafarbek.domain.data.ui.Topic
import uz.zafarbek.main.ui.fragments.InformationFragment
import uz.zafarbek.main.ui.fragments.TestFragment

class TeachingPagerAdapter(fm: Fragment, val data: List<Topic>): FragmentStateAdapter(fm) {
    override fun getItemCount(): Int =data.size

    var onNextClicked: OnActionListener<Boolean>? = null

    override fun createFragment(position: Int): Fragment {
        return if(data[position].tests?.isNullOrEmpty() == true){
            InformationFragment.instance(data[position], onNextClicked)
        }else{
            TestFragment.instance(data[position],onNextClicked)
        }
    }
}
package uz.zafarbek.main.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.zafarbek.main.ui.enums.HomeType
import uz.zafarbek.main.ui.fragments.DescriptionFragment
import uz.zafarbek.main.ui.fragments.IndexFragment


/**
 * Created by Zafarjon Toshtemirov on 4/7/21
 */

class HomePagerAdapter(fm:Fragment, val data:Array<HomeType>):FragmentStateAdapter(fm) {
    override fun getItemCount(): Int =data.size

    override fun createFragment(position: Int): Fragment {
        return  when(position){
            0-> {
                IndexFragment.instance(data[position])
            }
            else-> {
                DescriptionFragment.instance(data[position])
            }

        }

    }
}
package uz.zafarbek.main.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import uz.zafarbek.core.base.BaseViewHolder
import uz.zafarbek.core.utils.ktx.OnActionListener
import uz.zafarbek.core.utils.ktx.inflate
import uz.zafarbek.domain.data.ui.Course
import uz.zafarbek.domain.data.ui.Section
import uz.zafarbek.main.databinding.ItemCoursesBinding


class CoursesAdapter : ListAdapter<Course, BaseViewHolder<Course>>(Course.Companion.Comparator) {

    var onClick: OnActionListener<Section>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Course> {
        return CoursesVH(ItemCoursesBinding.inflate(parent.inflate, parent, false)) {
            onClick?.onAction(it)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Course>, position: Int) {
        holder.bind(getItem(position))
    }
}
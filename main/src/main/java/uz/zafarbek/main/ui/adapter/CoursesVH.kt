package uz.zafarbek.main.ui.adapter

import uz.zafarbek.core.base.BaseViewHolder
import uz.zafarbek.core.utils.ktx.OnActionListener
import uz.zafarbek.core.utils.ktx.addDivider
import uz.zafarbek.domain.data.ui.Course
import uz.zafarbek.domain.data.ui.Section
import uz.zafarbek.main.databinding.ItemCoursesBinding

class CoursesVH(
    private val binding: ItemCoursesBinding,
    private val onClick: (section: Section) -> Unit
) : BaseViewHolder<Course>(binding.root) {

    val adapter = SectionsAdapter()

    override fun bind(item: Course) {
        super.bind(item)
        binding.name.text = item.title
        binding.recycler.adapter = adapter
//        binding.recycler.addDivider(context)

        adapter.submitList(item.sections)
        adapter.onClick = OnActionListener {
            onClick(it)
        }
    }
}
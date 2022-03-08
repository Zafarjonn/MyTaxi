package uz.zafarbek.main.ui.adapter

import androidx.core.content.res.ResourcesCompat
import uz.zafarbek.core.base.BaseViewHolder
import uz.zafarbek.domain.data.ui.Course
import uz.zafarbek.domain.data.ui.Section
import uz.zafarbek.main.databinding.ItemCoursesBinding
import uz.zafarbek.main.databinding.ItemSectionBinding

class SectionsVH(
    private val binding: ItemSectionBinding,
    private val onClick: (section: Section) -> Unit
) : BaseViewHolder<Section>(binding.root) {
    override fun bind(item: Section) {
        super.bind(item)
        binding.titleSection.text = item.title
        binding.image.setImageDrawable(
            ResourcesCompat.getDrawable(
                context.resources,
                item.icon,
                null
            )
        )

        binding.root.setOnClickListener {
            onClick(item)
        }
    }
}
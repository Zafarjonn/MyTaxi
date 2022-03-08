package uz.zafarbek.main.ui.adapter

import uz.zafarbek.core.base.BaseViewHolder
import uz.zafarbek.domain.data.ui.Information
import uz.zafarbek.main.databinding.ItemInformationBinding

class InformationVH (
    private val binding: ItemInformationBinding,
    private val onClick: (information:Information) -> Unit
) : BaseViewHolder<Information>(binding.root) {

    override fun bind(item: Information) {
        super.bind(item)
        binding.information.text = item.text

        binding.root.setOnClickListener {
            onClick(item)
        }
    }

}
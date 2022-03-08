package uz.zafarbek.main.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import uz.zafarbek.core.base.BaseViewHolder
import uz.zafarbek.core.utils.ktx.OnActionListener
import uz.zafarbek.core.utils.ktx.inflate
import uz.zafarbek.domain.data.ui.Information
import uz.zafarbek.main.databinding.ItemInformationBinding

class InformationAdapter :
    ListAdapter<Information, BaseViewHolder<Information>>(Information.Companion.Comparator) {

    var onClick: OnActionListener<Information>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Information> {
        return InformationVH(ItemInformationBinding.inflate(parent.inflate, parent, false)) {
            onClick?.onAction(it)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Information>, position: Int) {
        holder.bind(getItem(position))
    }
}
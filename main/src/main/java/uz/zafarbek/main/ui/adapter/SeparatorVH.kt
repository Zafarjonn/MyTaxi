package uz.zafarbek.main.ui.adapter

import uz.zafarbek.core.base.BaseViewHolder
import uz.zafarbek.core.utils.ktx.formatToLongDate
import uz.zafarbek.domain.data.ui.OrderModel
import uz.zafarbek.main.databinding.ItemOrderHistorySeparatorBinding
import java.text.SimpleDateFormat
import java.util.*

class SeparatorVH(private val itemBinding: ItemOrderHistorySeparatorBinding) :
    BaseViewHolder<OrderModel>(itemBinding.root) {
    override fun bind(item: OrderModel) = with(itemBinding) {
        super.bind(item)
        if (item is OrderModel.SeparatorItem) {
            val dateObject = Date(item.date.formatToLongDate(SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())))
            val calendar = Calendar.getInstance()
            calendar.time = dateObject
            "${calendar.get(Calendar.DAY_OF_MONTH)} ${
                calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())
            }, ${
                calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault())
            }".apply {
                date.text = this
            }
        }
    }
}
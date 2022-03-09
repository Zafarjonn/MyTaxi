package uz.zafarbek.main.ui.adapter


import uz.zafarbek.core.base.BaseViewHolder
import uz.zafarbek.domain.data.ui.OrderModel
import uz.zafarbek.main.databinding.ItemOrderHistoryBinding
import java.text.SimpleDateFormat
import java.util.*

class OrderVH(
    private val itemBinding: ItemOrderHistoryBinding,
    private val onCLick: (id: String) -> Unit
) : BaseViewHolder<OrderModel>(itemBinding.root) {

    override fun bind(item: OrderModel) = with(itemBinding) {
        super.bind(item)
        if (item is OrderModel.OrderItem) {

            val calendar = Calendar.getInstance()


            root.setOnClickListener {
                onCLick(item.order.id)
            }
        }
    }
}
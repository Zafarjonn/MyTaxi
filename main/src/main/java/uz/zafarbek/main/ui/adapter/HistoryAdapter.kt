package uz.zafarbek.main.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import uz.zafarbek.core.base.BaseViewHolder
import uz.zafarbek.core.utils.ktx.OnActionListener
import uz.zafarbek.core.utils.ktx.inflate
import uz.zafarbek.domain.data.ui.OrderModel
import uz.zafarbek.main.R
import uz.zafarbek.main.databinding.ItemOrderHistoryBinding
import uz.zafarbek.main.databinding.ItemOrderHistorySeparatorBinding

class HistoryAdapter:  ListAdapter<OrderModel, BaseViewHolder<OrderModel>>(Comparator) {
    var onItemClickListener: OnActionListener<String>? = null


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<OrderModel> {
        return when (viewType) {
            R.layout.item_order_history ->
                OrderVH(ItemOrderHistoryBinding.inflate(parent.inflate(), parent, false)) {
                    onItemClickListener?.onAction(it)
                }
            else ->
                SeparatorVH(
                    ItemOrderHistorySeparatorBinding.inflate(
                        parent.inflate(),
                        parent,
                        false
                    )
                )
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<OrderModel>, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }


    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is OrderModel.OrderItem -> {
                    R.layout.item_order_history
            }
            is OrderModel.SeparatorItem -> R.layout.item_order_history_separator
            null -> throw UnsupportedOperationException("Unknown view")
        }
    }

    companion object {
        object Comparator : DiffUtil.ItemCallback<OrderModel>() {
            override fun areItemsTheSame(oldItem: OrderModel, newItem: OrderModel): Boolean {
                return (oldItem is OrderModel.OrderItem && newItem is OrderModel.OrderItem &&
                        oldItem.order.id == newItem.order.id) ||
                        (oldItem is OrderModel.SeparatorItem && newItem is OrderModel.SeparatorItem &&
                                oldItem.date == newItem.date)
            }

            override fun areContentsTheSame(oldItem: OrderModel, newItem: OrderModel): Boolean {
                return oldItem == newItem
            }

        }
    }

}
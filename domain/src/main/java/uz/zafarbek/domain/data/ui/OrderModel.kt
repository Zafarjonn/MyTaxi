package uz.zafarbek.domain.data.ui

sealed class OrderModel {
    data class OrderItem(val order: Order) : OrderModel()
    data class SeparatorItem(val date: String) : OrderModel()
}
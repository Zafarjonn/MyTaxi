package uz.zafarbek.domain.data.ui

data class Order(
    val id:String,
    val orderTime: String,
    val paymentType: String,
    val status: String,
    val address: String,
    val amountType: String,
    val amount: Double?,
    val otherPhoneNumber: String?,
    val scheduledTime: String?,
    val totalSum: Double?,
    val createdAt: String,
    val updatedAt: String,
    val doneAt: String?
)
package uz.zafarbek.domain.data.ui


data class Test(
    val id: String?,
    val question: String,
    val variants: List<String>,
    val correct: String,
    val isComplete: Boolean
)

package uz.zafarbek.domain.data.ui

import androidx.recyclerview.widget.DiffUtil
import uz.zafarbek.domain.data.database.CourseEntity
import uz.zafarbek.domain.data.database.TopicEntity

data class Topic(
    val id: String,
    val isComplete: Boolean,
    val image: Int?,
    val information: List<Information>?,
    val tests: List<Test>?
){
    fun toUi(): TopicEntity = TopicEntity(id, isComplete, image, null, null)
    companion object {
        object Comparator : DiffUtil.ItemCallback<Topic>() {
            override fun areItemsTheSame(oldItem: Topic, newItem: Topic): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Topic, newItem: Topic): Boolean {
                return oldItem == newItem
            }
        }
    }
}

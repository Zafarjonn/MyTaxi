package uz.zafarbek.domain.data.ui

import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.zafarbek.domain.data.database.CourseEntity

data class Course(
    val id: String,
    val title: String,
    val icon: Int,
    val sections: List<Section>?,
    val isCompleted: Boolean
) {
    fun toUi(): CourseEntity = CourseEntity(id, title, icon, null, isCompleted)
    companion object {
        object Comparator : DiffUtil.ItemCallback<Course>() {
            override fun areItemsTheSame(oldItem: Course, newItem: Course): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Course, newItem: Course): Boolean {
                return oldItem == newItem
            }
        }
    }
}

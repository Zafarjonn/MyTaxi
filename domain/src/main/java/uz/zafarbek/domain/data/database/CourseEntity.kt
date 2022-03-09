package uz.zafarbek.domain.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.zafarbek.domain.data.ui.Course

@Entity(tableName = "course")
data class CourseEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "icon")
    val icon: Int,
    @ColumnInfo(name = "sections")
    var sections: List<String>?,
    @ColumnInfo(name = "is_completed")
    val isCompleted: Boolean
) {
    fun toUi(): Course = Course(id, title, icon, null, isCompleted)
}

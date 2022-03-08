package uz.zafarbek.domain.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import uz.zafarbek.domain.data.ui.Section

@Entity(tableName = "section")
data class SectionEntity(
    @NotNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "is_complete")
    val isComplete: Boolean,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "icon")
    val icon: Int,
    @ColumnInfo(name = "topics")
    val topics: List<String>?
) {
    fun toUi() = Section(id, isComplete, title, icon, null,)
}

package uz.zafarbek.domain.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import uz.zafarbek.domain.data.ui.Information
import uz.zafarbek.domain.data.ui.Test
import uz.zafarbek.domain.data.ui.Topic

@Entity(tableName = "topic")
data class TopicEntity(
    @NotNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "is_complete")
    val isComplete: Boolean,
    @ColumnInfo(name = "image")
    val image: Int?,
    @ColumnInfo(name = "information")
    val information: List<String>?,
    @ColumnInfo(name = "tests")
    val tests: List<String>?
) {
    fun toUi(): Topic = Topic(id, isComplete, image, null, null)
}

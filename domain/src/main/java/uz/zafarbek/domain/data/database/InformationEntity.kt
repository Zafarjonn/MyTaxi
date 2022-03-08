package uz.zafarbek.domain.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import uz.zafarbek.domain.data.ui.Information


@Entity(tableName = "information")
data class InformationEntity(
    @NotNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "audio")
    val audio: Int,
    @ColumnInfo(name = "text")
    val text: String,
    @ColumnInfo(name = "is_completed")
    val isCompleted: Boolean
) {
    fun toUi(): Information = Information(id, audio, text, isCompleted)
}

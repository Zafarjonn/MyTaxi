package uz.zafarbek.domain.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import uz.zafarbek.domain.data.ui.Test

@Entity(tableName = "test")
data class TestEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "question")
    val question: String,
    @ColumnInfo(name = "variants")
    val variants: List<String>,
    @ColumnInfo(name = "correct")
    val correct: String,
    @ColumnInfo(name = "is_complete")
    val isComplete: Boolean
) {
    fun toUi(): Test = Test(id, question, variants, correct,isComplete)
}

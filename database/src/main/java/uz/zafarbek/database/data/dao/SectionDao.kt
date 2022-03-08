package uz.zafarbek.database.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.zafarbek.domain.data.database.CourseEntity
import uz.zafarbek.domain.data.database.SectionEntity

@Dao
abstract class SectionDao : BaseDao<SectionEntity> {

    @Query("select * from section")
    abstract suspend fun getAll(): List<SectionEntity>

    @Query("select * from section where id in (:ids) ")
    abstract suspend fun getById(vararg ids: String): List<SectionEntity>

    @Query("update section set is_complete = :bool where id == :id")
    abstract suspend fun setCompleteState(id: String, bool: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract  suspend fun insertSections(list: List<SectionEntity>)
}
package uz.zafarbek.database.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.zafarbek.domain.data.database.CourseEntity
import uz.zafarbek.domain.data.database.InformationEntity

@Dao
abstract class InformationDao : BaseDao<InformationEntity> {

    @Query("select * from information")
    abstract suspend fun getAll(): List<InformationEntity>

    @Query("select * from information where id in (:ids) ")
    abstract suspend fun getById(vararg ids: String): List<InformationEntity>

    @Query("update information set is_completed = :bool where id == :id")
    abstract suspend fun setCompleteState(id: String, bool: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract  suspend fun insertInformations(list: List<InformationEntity>)
}
package uz.zafarbek.database.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.zafarbek.domain.data.database.CourseEntity
import uz.zafarbek.domain.data.database.SectionEntity
import uz.zafarbek.domain.data.database.TopicEntity

@Dao
abstract class TopicDao : BaseDao<TopicEntity> {

    @Query("select * from topic")
    abstract suspend fun getAll(): List<TopicEntity>

    @Query("select * from topic where id in (:ids) ")
    abstract suspend fun getById(vararg ids: String): List<TopicEntity>

    @Query("update topic set is_complete = :bool where id == :id")
    abstract suspend fun setCompleteState(id: String, bool: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract  suspend fun insertTopics(list: List<TopicEntity>)
}
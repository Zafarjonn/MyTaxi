package uz.zafarbek.database.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.zafarbek.domain.data.database.CourseEntity
import uz.zafarbek.domain.data.ui.Course

@Dao
abstract class CourseDao : BaseDao<CourseEntity> {

    @Query("select * from course")
    abstract suspend  fun getAll(): List<CourseEntity>

    @Query("select * from course where id in (:ids) ")
    abstract suspend fun getById(vararg ids: String): List<CourseEntity>

    @Query("update course set is_completed = :bool where id == :id")
    abstract suspend fun setCompleteState(id: String, bool: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract  suspend fun insertCourses(list: List<CourseEntity>)

//    @Query("select * from topic where id = :id")
//    abstract suspend fun getTopic todo
}
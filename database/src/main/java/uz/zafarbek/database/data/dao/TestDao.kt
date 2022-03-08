package uz.zafarbek.database.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.zafarbek.domain.data.database.CourseEntity
import uz.zafarbek.domain.data.database.TestEntity

@Dao
abstract class TestDao : BaseDao<TestEntity> {

    @Query("select * from test")
    abstract suspend fun getAll(): List<TestEntity>

    @Query("select * from test where id in (:ids) ")
    abstract suspend fun getById(vararg ids: String): List<TestEntity>

    @Query("update test set is_complete = :bool where id == :id")
    abstract suspend fun setCompleteState(id: String, bool: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract  suspend fun insertTests(list: List<TestEntity>)
}
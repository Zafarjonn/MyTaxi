package uz.zafarbek.domain.ports.database

import kotlinx.coroutines.flow.Flow
import uz.zafarbek.domain.data.database.TestEntity
import uz.zafarbek.domain.data.ui.Course
import uz.zafarbek.domain.data.ui.Test

interface DatabaseTestPort {
    suspend fun insert(vararg data: TestEntity)

    suspend fun insertAll(data:List<TestEntity>)

    suspend fun update(data: TestEntity)

    suspend fun updateState(id: String, isComplete: Boolean)

    suspend fun getAll(): List<TestEntity>

    suspend fun getById(vararg ids: String): List<TestEntity>
}
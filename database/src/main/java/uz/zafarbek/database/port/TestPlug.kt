package uz.zafarbek.database.port

import kotlinx.coroutines.flow.Flow
import uz.zafarbek.database.data.dao.TestDao
import uz.zafarbek.domain.data.database.TestEntity
import uz.zafarbek.domain.data.ui.Test
import uz.zafarbek.domain.mappers.TestEMMapper
import uz.zafarbek.domain.ports.database.DatabaseTestPort
import javax.inject.Inject


class TestPlug @Inject constructor(
    private val dao: TestDao,
    private val testEMMapper: TestEMMapper
) : DatabaseTestPort {
    override suspend fun insert(vararg data: TestEntity) {
        dao.insert(*data)
    }

    override suspend fun insertAll(data: List<TestEntity>) {
        dao.insertTests(data)
    }

    override suspend fun update(data: TestEntity) {
        dao.update(data)
    }

    override suspend fun updateState(id: String, isComplete: Boolean) {
        dao.setCompleteState(id, isComplete)
    }

    override suspend fun getAll(): List<TestEntity> {
        return dao.getAll()
    }

    override suspend fun getById(vararg ids: String): List<TestEntity> {
        return dao.getById(*ids)
    }
}
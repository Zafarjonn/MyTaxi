package uz.zafarbek.database.port

import kotlinx.coroutines.flow.Flow
import uz.zafarbek.database.data.dao.SectionDao
import uz.zafarbek.domain.data.database.SectionEntity
import uz.zafarbek.domain.data.ui.Section
import uz.zafarbek.domain.mappers.SectionEMMapper
import uz.zafarbek.domain.ports.database.DatabaseSectionPort
import javax.inject.Inject

class SectionPlug @Inject constructor(
    private val dao: SectionDao,
    private val sectionEMMapper: SectionEMMapper
) : DatabaseSectionPort {
    override suspend fun insert(vararg data: SectionEntity) {
        dao.insert(*data)
    }

    override suspend fun insertAll(data: List<Section>) {
        dao.insertSections(sectionEMMapper.mapToEntityList(data))
    }

    override suspend fun update(data: SectionEntity) {
        dao.update(data)
    }

    override suspend fun updateState(id: String, isComplete: Boolean) {
        dao.setCompleteState(id, isComplete)
    }

    override suspend fun getAll(): List<SectionEntity> {
        return dao.getAll()
    }

    override suspend fun getById(vararg ids: String): List<SectionEntity> {
        return dao.getById(*ids)
    }
}
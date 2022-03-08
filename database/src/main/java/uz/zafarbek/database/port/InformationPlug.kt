package uz.zafarbek.database.port

import uz.zafarbek.database.data.dao.InformationDao
import uz.zafarbek.domain.data.database.InformationEntity
import uz.zafarbek.domain.data.ui.Information
import uz.zafarbek.domain.mappers.InformationEMMapper
import uz.zafarbek.domain.ports.database.DatabaseInformationPort
import javax.inject.Inject


class InformationPlug @Inject constructor(private val dao: InformationDao, private val informationEMMapper: InformationEMMapper) :
    DatabaseInformationPort {
    override suspend fun insert(vararg data: InformationEntity) {
        dao.insert(*data)
    }

    override suspend fun insertAll(data: List<InformationEntity>) {
        dao.insertInformations(data)
    }

    override suspend fun update(data: InformationEntity) {
        dao.update(data)
    }

    override suspend fun updateState(id: String, isComplete: Boolean) {
        dao.setCompleteState(id, isComplete)
    }

    override suspend fun getAll(): List<InformationEntity> {
        return dao.getAll()
    }

    override suspend fun getById(vararg ids: String): List<InformationEntity> {
        return dao.getById(*ids)
    }
}
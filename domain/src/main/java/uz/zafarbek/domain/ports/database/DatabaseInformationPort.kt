package uz.zafarbek.domain.ports.database

import kotlinx.coroutines.flow.Flow
import uz.zafarbek.domain.data.database.InformationEntity
import uz.zafarbek.domain.data.ui.Course
import uz.zafarbek.domain.data.ui.Information

interface DatabaseInformationPort {
    suspend fun insert(vararg data: InformationEntity)

    suspend fun insertAll(data:List<InformationEntity>)

    suspend fun update(data: InformationEntity)

    suspend fun updateState(id: String, isComplete: Boolean)

    suspend fun getAll(): List<InformationEntity>

    suspend fun getById(vararg ids: String): List<InformationEntity>
}
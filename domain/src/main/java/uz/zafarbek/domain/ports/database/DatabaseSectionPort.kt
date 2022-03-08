package uz.zafarbek.domain.ports.database

import kotlinx.coroutines.flow.Flow
import uz.zafarbek.domain.data.database.SectionEntity
import uz.zafarbek.domain.data.ui.Course
import uz.zafarbek.domain.data.ui.Section

interface DatabaseSectionPort {
    suspend fun insert(vararg data: SectionEntity)

    suspend fun insertAll(data:List<Section>)

    suspend fun update(data: SectionEntity)

    suspend fun updateState(id: String, isComplete: Boolean)

    suspend fun getAll(): List<SectionEntity>

    suspend fun getById(vararg ids: String): List<SectionEntity>
}
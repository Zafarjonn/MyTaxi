package uz.zafarbek.domain.ports.database

import kotlinx.coroutines.flow.Flow
import uz.zafarbek.domain.data.database.TopicEntity
import uz.zafarbek.domain.data.ui.Course
import uz.zafarbek.domain.data.ui.Topic


interface DatabaseTopicPort {

    suspend fun insert(vararg data: TopicEntity)

    suspend fun update(data: TopicEntity)

    suspend fun updateState(id: String, isComplete: Boolean)

    suspend fun getAll(): List<TopicEntity>

    suspend fun getById(vararg ids: String): List<TopicEntity>

    suspend fun insertAllTopics(data:List<TopicEntity>)

}
package uz.zafarbek.database.port

import uz.zafarbek.database.data.dao.TopicDao
import uz.zafarbek.domain.data.database.TopicEntity
import uz.zafarbek.domain.data.ui.Topic
import uz.zafarbek.domain.mappers.TopicsEMMapper
import uz.zafarbek.domain.ports.database.DatabaseTopicPort
import javax.inject.Inject


class TopicPlug @Inject constructor(
    private val dao: TopicDao,
    private val topicsEMMapper: TopicsEMMapper
) : DatabaseTopicPort {
    override suspend fun insert(vararg data: TopicEntity) {
        dao.insert(*data)
    }

    override suspend fun update(data: TopicEntity) {
        dao.update(data)
    }

    override suspend fun updateState(id: String, isComplete: Boolean) {
        dao.setCompleteState(id, isComplete)
    }

    override suspend fun getAll(): List<TopicEntity> {
        return dao.getAll()
    }

    override suspend fun getById(vararg ids: String): List<TopicEntity> {
        return dao.getById(*ids)
    }

    override suspend fun insertAllTopics(data: List<TopicEntity>) {
        dao.insertTopics(data)
    }
}
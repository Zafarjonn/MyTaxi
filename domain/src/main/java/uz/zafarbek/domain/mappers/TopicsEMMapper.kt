package uz.zafarbek.domain.mappers

import uz.zafarbek.domain.mapper.EntityModelMapper
import uz.zafarbek.domain.data.database.TopicEntity
import uz.zafarbek.domain.data.ui.Topic
import javax.inject.Inject

class TopicsEMMapper @Inject constructor(
    private val informationEMMapper: InformationEMMapper,
    private val testEMMapper: TestEMMapper
) : EntityModelMapper<TopicEntity, Topic>() {
    override fun mapFromEntity(entity: TopicEntity): Topic =
        Topic(
            id = entity.id,
            isComplete = entity.isComplete,
            image = entity.image,
            information = null,
            tests = null
        )

    override fun mapToEntity(model: Topic): TopicEntity =
        TopicEntity(
            id = model.id,
            isComplete = model.isComplete,
            image = model.image,
            information = model.information?.map { it.id },
            tests = model.tests?.map { it.id ?: "" }
        )
}
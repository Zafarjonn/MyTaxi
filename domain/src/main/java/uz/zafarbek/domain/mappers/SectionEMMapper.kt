package uz.zafarbek.domain.mappers

import uz.zafarbek.domain.mapper.EntityModelMapper
import uz.zafarbek.domain.data.database.SectionEntity
import uz.zafarbek.domain.data.ui.Section
import javax.inject.Inject

class SectionEMMapper @Inject constructor(): EntityModelMapper<SectionEntity, Section>() {
    override fun mapFromEntity(entity: SectionEntity): Section =
        Section(
         id=entity.id,
         isComplete=entity.isComplete,
         title=entity.title,
         icon=entity.icon,
         topics=entity.topics,
        )

    override fun mapToEntity(model: Section): SectionEntity =
        SectionEntity(
            id=model.id,
            isComplete=model.isComplete,
            title=model.title,
            icon=model.icon,
            topics=model.topics,
        )
}
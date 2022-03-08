package uz.zafarbek.domain.mappers

import uz.zafarbek.domain.mapper.EntityModelMapper
import uz.zafarbek.domain.data.database.InformationEntity
import uz.zafarbek.domain.data.ui.Information
import javax.inject.Inject

class InformationEMMapper @Inject constructor():
    EntityModelMapper<InformationEntity, Information>() {
    override fun mapFromEntity(entity: InformationEntity): Information =
        Information(
         id=entity.id,
         audio=entity.audio,
         text=entity.text,
         isCompleted=entity.isCompleted
        )

    override fun mapToEntity(model: Information): InformationEntity =
        InformationEntity(
            id=model.id,
            audio=model.audio,
            text=model.text,
            isCompleted=model.isCompleted
        )
}
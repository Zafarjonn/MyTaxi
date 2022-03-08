package uz.zafarbek.domain.mappers

import uz.zafarbek.domain.mapper.EntityModelMapper
import uz.zafarbek.domain.data.database.TestEntity
import uz.zafarbek.domain.data.ui.Test
import javax.inject.Inject

class TestEMMapper @Inject constructor() : EntityModelMapper<TestEntity, Test>() {
    override fun mapFromEntity(entity: TestEntity): Test =
        Test(
            id = entity.id,
            question = entity.question,
            variants = entity.variants,
            correct = entity.correct,
            isComplete = entity.isComplete
        )

    override fun mapToEntity(model: Test): TestEntity =
        TestEntity(
            id = model.id ?: "",
            question = model.question,
            variants = model.variants,
            correct = model.correct,
            isComplete = model.isComplete
        )

}
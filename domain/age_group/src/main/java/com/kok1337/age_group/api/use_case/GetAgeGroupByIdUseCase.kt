package com.kok1337.age_group.api.use_case

import com.kok1337.age_group.api.AgeGroupRepository
import com.kok1337.age_group.api.model.AgeGroup
import com.kok1337.age_group.internal.mapper.AgeGroupMapper

class GetAgeGroupByIdUseCase(
    private val ageGroupRepository: AgeGroupRepository,
) {
    suspend operator fun invoke(id: Int): AgeGroup {
        val apiModel = ageGroupRepository.findById(id)
        return AgeGroupMapper.fromApiModel(apiModel)
    }
}
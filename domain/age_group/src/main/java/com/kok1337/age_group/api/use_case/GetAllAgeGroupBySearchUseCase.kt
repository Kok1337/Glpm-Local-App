package com.kok1337.age_group.api.use_case

import com.kok1337.age_group.api.AgeGroupRepository
import com.kok1337.age_group.api.model.AgeGroup
import com.kok1337.age_group.internal.mapper.AgeGroupMapper

class GetAllAgeGroupBySearchUseCase(
    private val ageGroupRepository: AgeGroupRepository,
) {
    suspend operator fun invoke(search: String): List<AgeGroup> {
        val apiModelList = ageGroupRepository.findAllWithSearch(search)
        return apiModelList.map(AgeGroupMapper::fromApiModel)
    }
}
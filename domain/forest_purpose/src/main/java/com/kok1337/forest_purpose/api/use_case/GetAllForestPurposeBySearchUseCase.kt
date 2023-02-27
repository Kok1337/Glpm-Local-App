package com.kok1337.forest_purpose.api.use_case

import com.kok1337.forest_purpose.api.ForestPurposeRepository
import com.kok1337.forest_purpose.api.model.ForestPurpose
import com.kok1337.forest_purpose.internal.mapper.ForestPurposeMapper

class GetAllForestPurposeBySearchUseCase(
    private val forestPurposeRepository: ForestPurposeRepository,
) {
    suspend operator fun invoke(search: String): List<ForestPurpose> {
        val apiModelList = forestPurposeRepository.findAllWithSearch(search)
        return apiModelList.map(ForestPurposeMapper::fromApiModel)
    }
}
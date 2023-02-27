package com.kok1337.forest_purpose.api.use_case

import com.kok1337.forest_purpose.internal.mapper.ForestPurposeMapper
import com.kok1337.forest_purpose.api.ForestPurposeRepository
import com.kok1337.forest_purpose.api.model.ForestPurpose

class GetForestPurposeByIdUseCase(
    private val forestPurposeRepository: ForestPurposeRepository,
) {
    suspend operator fun invoke(id: Int): ForestPurpose {
        val apiModel = forestPurposeRepository.findById(id)
        return ForestPurposeMapper.fromApiModel(apiModel)
    }
}
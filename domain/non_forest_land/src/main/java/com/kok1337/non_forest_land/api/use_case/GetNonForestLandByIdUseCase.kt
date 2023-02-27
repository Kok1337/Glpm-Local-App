package com.kok1337.non_forest_land.api.use_case

import com.kok1337.non_forest_land.api.NonForestLandRepository
import com.kok1337.non_forest_land.api.model.NonForestLand
import com.kok1337.non_forest_land.internal.mapper.NonForestLandMapper

class GetNonForestLandByIdUseCase(
    private val nonForestLandRepository: NonForestLandRepository,
) {
    suspend operator fun invoke(id: Int): NonForestLand {
        val apiModel = nonForestLandRepository.findById(id)
        return NonForestLandMapper.fromApiModel(apiModel)
    }
}
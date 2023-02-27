package com.kok1337.non_forest_land.api.use_case

import com.kok1337.non_forest_land.api.NonForestLandRepository
import com.kok1337.non_forest_land.api.model.NonForestLand
import com.kok1337.non_forest_land.internal.mapper.NonForestLandMapper

class GetAllNonForestLandBySearchUseCase(
    private val nonForestLandRepository: NonForestLandRepository,
) {
    suspend operator fun invoke(search: String): List<NonForestLand> {
        val apiModelList = nonForestLandRepository.findAllWithSearch(search)
        return apiModelList.map(NonForestLandMapper::fromApiModel)
    }
}
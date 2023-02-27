package com.kok1337.land.api.use_case

import com.kok1337.land.api.LandRepository
import com.kok1337.land.api.model.Land
import com.kok1337.land.internal.mapper.LandMapper

class GetLandByIsForestLand(
    private val landRepository: LandRepository,
) {
    suspend operator fun invoke(isForestLand: Boolean): Land {
        val apiModel = landRepository.findByIsForestLand(isForestLand)
        return LandMapper.fromApiModel(apiModel)
    }
}
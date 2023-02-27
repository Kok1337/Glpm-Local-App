package com.kok1337.land.api.use_case

import com.kok1337.land.api.LandRepository
import com.kok1337.land.api.model.Land
import com.kok1337.land.internal.mapper.LandMapper

class GetAllLandUseCase(
    private val landRepository: LandRepository,
) {
    suspend operator fun invoke(): List<Land> {
        val apiModelList = landRepository.findAll()
        return apiModelList.map(LandMapper::fromApiModel)
    }
}
package com.kok1337.unforested_land.api.use_case

import com.kok1337.unforested_land.api.UnforestedLandRepository
import com.kok1337.unforested_land.api.model.UnforestedLand
import com.kok1337.unforested_land.internal.mapper.UnforestedLandMapper

class GetAllUnforestedLandBySearchUseCase(
    private val unforestedLandRepository: UnforestedLandRepository,
) {
    suspend operator fun invoke(search: String): List<UnforestedLand> {
        val apiModelList = unforestedLandRepository.findAllWithSearch(search)
        return apiModelList.map(UnforestedLandMapper::fromApiModel)
    }
}
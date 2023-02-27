package com.kok1337.unforested_land.api.use_case

import com.kok1337.unforested_land.api.UnforestedLandRepository
import com.kok1337.unforested_land.api.model.UnforestedLand
import com.kok1337.unforested_land.internal.mapper.UnforestedLandMapper

class GetUnforestedLandByIdUseCase(
    private val unforestedLandRepository: UnforestedLandRepository,
) {
    suspend operator fun invoke(id: Int): UnforestedLand {
        val apiModel = unforestedLandRepository.findById(id)
        return UnforestedLandMapper.fromApiModel(apiModel)
    }
}
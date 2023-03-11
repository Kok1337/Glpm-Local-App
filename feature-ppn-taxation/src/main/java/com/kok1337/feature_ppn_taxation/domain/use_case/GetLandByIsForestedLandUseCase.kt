package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.taxation.data.repository.LandFixedRepository
import com.kok1337.taxation.domain.model.Land
import javax.inject.Inject

internal class GetLandByIsForestedLandUseCase @Inject constructor(
    private val landFixedRepository: LandFixedRepository,
) {
    suspend operator fun invoke(isForestLand: Boolean): Land {
        return landFixedRepository.findByIsForestLand(isForestLand)
    }
}
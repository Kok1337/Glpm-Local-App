package com.kok1337.feature_ppn_description.domain.use_case

import com.kok1337.feature_ppn_description.di.LocalityInMemoryRepository
import javax.inject.Inject

internal class EnterAreaUseCase @Inject constructor(
    private val localityInMemoryRepository: LocalityInMemoryRepository,
) {
    operator fun invoke(area: String?) {
        localityInMemoryRepository.updateArea(area)
    }
}
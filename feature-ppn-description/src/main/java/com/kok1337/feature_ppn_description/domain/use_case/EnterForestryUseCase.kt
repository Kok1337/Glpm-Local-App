package com.kok1337.feature_ppn_description.domain.use_case

import com.kok1337.address.domain.model.Forestry
import com.kok1337.feature_ppn_description.di.LocalityInMemoryRepository
import javax.inject.Inject

internal class EnterForestryUseCase @Inject constructor(
    private val localityInMemoryRepository: LocalityInMemoryRepository,
) {
    operator fun invoke(forestry: Forestry?) {
        localityInMemoryRepository.updateForestry(forestry)
    }
}
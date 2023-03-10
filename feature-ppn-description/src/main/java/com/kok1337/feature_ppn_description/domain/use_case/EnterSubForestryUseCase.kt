package com.kok1337.feature_ppn_description.domain.use_case

import com.kok1337.address.domain.model.SubForestry
import com.kok1337.feature_ppn_description.data.repository.LocalityInMemoryRepository
import javax.inject.Inject

internal class EnterSubForestryUseCase @Inject constructor(
    private val localityInMemoryRepository: LocalityInMemoryRepository,
) {
    operator fun invoke(subForestry: SubForestry?) {
        localityInMemoryRepository.updateSubForestry(subForestry)
    }
}
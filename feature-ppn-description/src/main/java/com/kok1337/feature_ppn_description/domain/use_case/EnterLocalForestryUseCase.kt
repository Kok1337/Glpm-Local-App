package com.kok1337.feature_ppn_description.domain.use_case

import com.kok1337.address.domain.model.LocalForestry
import com.kok1337.feature_ppn_description.data.repository.LocalityInMemoryRepository
import javax.inject.Inject

internal class EnterLocalForestryUseCase @Inject constructor(
    private val localityInMemoryRepository: LocalityInMemoryRepository,
) {
    operator fun invoke(localForestry: LocalForestry?) {
        localityInMemoryRepository.updateLocalForestry(localForestry)
    }
}
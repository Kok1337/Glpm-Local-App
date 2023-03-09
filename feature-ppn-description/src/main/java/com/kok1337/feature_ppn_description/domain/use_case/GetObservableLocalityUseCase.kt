package com.kok1337.feature_ppn_description.domain.use_case

import com.kok1337.address.domain.model.Locality
import com.kok1337.feature_ppn_description.di.LocalityInMemoryRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

internal class GetObservableLocalityUseCase @Inject constructor(
    private val localityInMemoryRepository: LocalityInMemoryRepository,
) {
    operator fun invoke(): StateFlow<Locality> {
        return localityInMemoryRepository.getLocalityStateFlow()
    }
}
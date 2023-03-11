package com.kok1337.feature_ppn_description.domain.use_case

import com.kok1337.address.domain.model.Locality
import com.kok1337.feature_ppn_description.data.repository.DescriptionLocalityInMemoryRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

internal class GetObservableLocalityUseCase @Inject constructor(
    private val descriptionLocalityInMemoryRepository: DescriptionLocalityInMemoryRepository,
) {
    operator fun invoke(): StateFlow<Locality> {
        return descriptionLocalityInMemoryRepository.getLocalityStateFlow()
    }
}
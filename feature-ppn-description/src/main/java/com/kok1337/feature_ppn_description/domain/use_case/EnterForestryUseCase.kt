package com.kok1337.feature_ppn_description.domain.use_case

import com.kok1337.address.domain.model.Forestry
import com.kok1337.feature_ppn_description.data.repository.DescriptionLocalityInMemoryRepository
import javax.inject.Inject

internal class EnterForestryUseCase @Inject constructor(
    private val descriptionLocalityInMemoryRepository: DescriptionLocalityInMemoryRepository,
) {
    operator fun invoke(forestry: Forestry?) {
        descriptionLocalityInMemoryRepository.updateForestry(forestry)
    }
}
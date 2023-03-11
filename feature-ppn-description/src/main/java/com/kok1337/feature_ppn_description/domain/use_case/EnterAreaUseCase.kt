package com.kok1337.feature_ppn_description.domain.use_case

import com.kok1337.feature_ppn_description.data.repository.DescriptionLocalityInMemoryRepository
import javax.inject.Inject

internal class EnterAreaUseCase @Inject constructor(
    private val descriptionLocalityInMemoryRepository: DescriptionLocalityInMemoryRepository,
) {
    operator fun invoke(area: String?) {
        descriptionLocalityInMemoryRepository.updateArea(area)
    }
}
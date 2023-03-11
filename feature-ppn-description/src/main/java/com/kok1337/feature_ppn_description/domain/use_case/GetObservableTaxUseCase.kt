package com.kok1337.feature_ppn_description.domain.use_case

import com.kok1337.feature_ppn_description.data.repository.DescriptionTaxInMemoryRepository
import com.kok1337.taxation.domain.model.Tax
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

internal class GetObservableTaxUseCase @Inject constructor(
    private val descriptionTaxInMemoryRepository: DescriptionTaxInMemoryRepository,
) {
    operator fun invoke(): StateFlow<Tax?> {
        return descriptionTaxInMemoryRepository.getTaxStateFlow()
    }
}
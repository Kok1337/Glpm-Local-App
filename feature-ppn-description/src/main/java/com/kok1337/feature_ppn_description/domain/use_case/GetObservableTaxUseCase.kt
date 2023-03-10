package com.kok1337.feature_ppn_description.domain.use_case

import com.kok1337.feature_ppn_description.data.repository.TaxInMemoryRepository
import com.kok1337.taxation.domain.model.Tax
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

internal class GetObservableTaxUseCase @Inject constructor(
    private val taxInMemoryRepository: TaxInMemoryRepository,
) {
    operator fun invoke(): StateFlow<Tax?> {
        return taxInMemoryRepository.getTaxStateFlow()
    }
}
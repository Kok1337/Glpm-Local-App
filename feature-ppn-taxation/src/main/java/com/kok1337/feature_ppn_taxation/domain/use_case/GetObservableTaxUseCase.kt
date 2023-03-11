package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxInMemoryRepository
import com.kok1337.taxation.domain.model.Tax
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

internal class GetObservableTaxUseCase @Inject constructor(
    private val taxationTaxInMemoryRepository: TaxationTaxInMemoryRepository,
) {
    operator fun invoke(): StateFlow<Tax?> {
        return taxationTaxInMemoryRepository.getTaxStateFlow()
    }
}
package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxInMemoryRepository
import javax.inject.Inject

internal class EnterTaxForestTypeUseCase @Inject constructor(
    private val taxationTaxInMemoryRepository: TaxationTaxInMemoryRepository,
) {
    operator fun invoke(forestType: String?) {
        taxationTaxInMemoryRepository.updateForestType(forestType)
    }
}
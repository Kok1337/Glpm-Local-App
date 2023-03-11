package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxInMemoryRepository
import com.kok1337.taxation.domain.model.ForestPurpose
import javax.inject.Inject

internal class EnterTaxForestPurposeUseCase @Inject constructor(
    private val taxationTaxInMemoryRepository: TaxationTaxInMemoryRepository,
) {
    operator fun invoke(forestPurpose: ForestPurpose?) {
        taxationTaxInMemoryRepository.updateForestPurpose(forestPurpose)
    }
}
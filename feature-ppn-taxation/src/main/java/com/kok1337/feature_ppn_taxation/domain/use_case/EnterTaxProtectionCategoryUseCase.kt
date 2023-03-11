package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxInMemoryRepository
import com.kok1337.taxation.domain.model.ProtectionCategory
import javax.inject.Inject

internal class EnterTaxProtectionCategoryUseCase @Inject constructor(
    private val taxationTaxInMemoryRepository: TaxationTaxInMemoryRepository,
) {
    operator fun invoke(protectionCategory: ProtectionCategory?) {
        taxationTaxInMemoryRepository.updateProtectionCategory(protectionCategory)
    }
}
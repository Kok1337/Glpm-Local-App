package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxInMemoryRepository
import com.kok1337.taxation.domain.model.Ozu
import javax.inject.Inject

internal class EnterTaxOzuUseCase @Inject constructor(
    private val taxationTaxInMemoryRepository: TaxationTaxInMemoryRepository,
) {
    operator fun invoke(ozu: Ozu?) {
        taxationTaxInMemoryRepository.updateOzu(ozu)
    }
}
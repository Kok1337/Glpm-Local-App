package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxInMemoryRepository
import com.kok1337.taxation.domain.model.NonForestLand
import javax.inject.Inject

internal class EnterTaxNonForestLandUseCase @Inject constructor(
    private val taxationTaxInMemoryRepository: TaxationTaxInMemoryRepository,
) {
    operator fun invoke(nonForestLand: NonForestLand?) {
        taxationTaxInMemoryRepository.updateNonForestLand(nonForestLand)
    }
}
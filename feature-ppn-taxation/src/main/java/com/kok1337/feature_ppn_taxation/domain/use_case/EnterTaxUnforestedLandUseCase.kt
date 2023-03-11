package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxInMemoryRepository
import com.kok1337.taxation.domain.model.UnforestedLand
import javax.inject.Inject

internal class EnterTaxUnforestedLandUseCase @Inject constructor(
    private val taxationTaxInMemoryRepository: TaxationTaxInMemoryRepository,
) {
    operator fun invoke(unforestedLand: UnforestedLand?) {
        taxationTaxInMemoryRepository.updateUnforestedLand(unforestedLand)
    }
}
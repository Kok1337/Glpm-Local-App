package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxLayerInMemoryRepository
import java.util.*
import javax.inject.Inject

internal class EnterTaxLayerAgeClassByIdUseCase @Inject constructor(
    private val taxationTaxLayerInMemoryRepository: TaxationTaxLayerInMemoryRepository,
) {
    operator fun invoke(taxLayerId: UUID, ageClass: Int?) {
        taxationTaxLayerInMemoryRepository.updateAgeClass(taxLayerId, ageClass)
    }
}
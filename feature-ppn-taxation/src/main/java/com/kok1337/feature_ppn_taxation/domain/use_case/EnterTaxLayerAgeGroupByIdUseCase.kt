package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxLayerInMemoryRepository
import com.kok1337.taxation.domain.model.AgeGroup
import java.util.*
import javax.inject.Inject

internal class EnterTaxLayerAgeGroupByIdUseCase @Inject constructor(
    private val taxationTaxLayerInMemoryRepository: TaxationTaxLayerInMemoryRepository,
) {
    operator fun invoke(taxLayerId: UUID, ageGroup: AgeGroup?) {
        taxationTaxLayerInMemoryRepository.updateAgeGroup(taxLayerId, ageGroup)
    }
}
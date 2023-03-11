package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxSpeciesInMemoryRepository
import java.util.*
import javax.inject.Inject

internal class EnterTaxSpeciesDiameterByIdUseCase @Inject constructor(
    private val taxationTaxSpeciesInMemoryRepository: TaxationTaxSpeciesInMemoryRepository,
) {
    operator fun invoke(taxSpeciesId: UUID, diameter: Int?) {
        taxationTaxSpeciesInMemoryRepository.updateDiameter(taxSpeciesId, diameter)
    }
}
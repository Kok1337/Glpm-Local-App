package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxSpeciesInMemoryRepository
import java.util.*
import javax.inject.Inject

internal class EnterTaxSpeciesCoeffByIdUseCase @Inject constructor(
    private val taxationTaxSpeciesInMemoryRepository: TaxationTaxSpeciesInMemoryRepository,
) {
    operator fun invoke(taxSpeciesId: UUID, coeff: Int?) {
        taxationTaxSpeciesInMemoryRepository.updateCoeff(taxSpeciesId, coeff)
    }
}
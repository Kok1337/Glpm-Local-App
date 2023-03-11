package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxSpeciesInMemoryRepository
import com.kok1337.species.domain.model.Species
import java.util.*
import javax.inject.Inject

internal class EnterTaxSpeciesSpeciesByIdUseCase @Inject constructor(
    private val taxationTaxSpeciesInMemoryRepository: TaxationTaxSpeciesInMemoryRepository,
) {
    operator fun invoke(taxSpeciesId: UUID, species: Species?) {
        taxationTaxSpeciesInMemoryRepository.updateSpecies(taxSpeciesId, species)
    }
}
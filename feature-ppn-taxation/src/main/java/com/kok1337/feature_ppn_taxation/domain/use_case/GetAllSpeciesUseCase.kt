package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.species.data.repository.SpeciesFixedRepository
import com.kok1337.species.domain.model.Species
import javax.inject.Inject

internal class GetAllSpeciesUseCase @Inject constructor(
    private val speciesFixedRepository: SpeciesFixedRepository,
) {
    suspend operator fun invoke(): List<Species> {
        return speciesFixedRepository.findAll().toList()
    }
}
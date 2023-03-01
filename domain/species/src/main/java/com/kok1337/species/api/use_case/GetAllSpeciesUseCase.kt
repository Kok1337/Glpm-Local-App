package com.kok1337.species.api.use_case

import com.kok1337.species.api.SpeciesRepository
import com.kok1337.species.api.model.Species
import com.kok1337.species.internal.mapper.SpeciesMapper

class GetAllSpeciesUseCase(
    private val speciesRepository: SpeciesRepository,
) {
    suspend operator fun invoke(): List<Species> {
        val apiModelList = speciesRepository.findAll()
        return apiModelList.map(SpeciesMapper::fromApiModel)
    }
}
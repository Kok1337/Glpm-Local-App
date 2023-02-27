package com.kok1337.species

import com.kok1337.species.api.SpeciesDependencies
import com.kok1337.species.api.SpeciesRepositoryFactory

internal suspend fun main() {
    val speciesRepository = SpeciesRepositoryFactory.create(/*SpeciesDependenciesImpl()*/)
    speciesRepository.findAll().forEach { print(it) }
}

internal class SpeciesDependenciesImpl : SpeciesDependencies

package com.kok1337.species.api

import com.kok1337.species.internal.repository.SpeciesRepositoryImpl

object SpeciesRepositoryFactory {
    fun create(/*dependencies: SpeciesDependencies*/): SpeciesRepository {
        return SpeciesRepositoryImpl()
    }
}
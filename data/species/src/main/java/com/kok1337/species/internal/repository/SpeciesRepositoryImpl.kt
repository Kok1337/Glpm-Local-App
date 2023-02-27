package com.kok1337.species.internal.repository

import com.kok1337.species.api.SpeciesApiModel
import com.kok1337.species.api.SpeciesRepository

internal class SpeciesRepositoryImpl : SpeciesRepository {
    private val hardCodedSpecies = listOf(
        SpeciesApiModel(1, "Б", "Береза"),
        SpeciesApiModel(2, "С", "Сосна"),
        SpeciesApiModel(3, "Д", "Дуб"),
    )

    override suspend fun findAll(): List<SpeciesApiModel> {
        return hardCodedSpecies
    }

    override suspend fun findAllById(ids: Iterable<Int>): List<SpeciesApiModel> {
       return hardCodedSpecies.filter { it.id in ids }
    }

    override suspend fun findById(id: Int): SpeciesApiModel {
        return hardCodedSpecies.first { it.id ==  id}
    }
}
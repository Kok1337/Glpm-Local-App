package com.kok1337.species.data.repository

import com.kok1337.species.domain.model.Species

class SpeciesFixedRepository {
    private val hardCodedSpecies = listOf(
        Species(1, "Б", "Береза"),
        Species(2, "Е", "Ель"),
        Species(3, "К", "Кедр"),
        Species(4, "Л", "Лиственница"),
        Species(5, "ОС", "Осина"),
        Species(6, "П", "Пихта"),
        Species(7, "С", "Сосна"),
    )

    suspend fun findAll(): Iterable<Species> {
        return hardCodedSpecies
    }

    suspend fun findById(id: Int): Species? {
        return hardCodedSpecies.firstOrNull { species -> species.id == id }
    }

    suspend fun findAllWithSearch(search: String): Iterable<Species> {
        return hardCodedSpecies.filter { it.fullName.lowercase().contains(search.lowercase()) }
    }
}
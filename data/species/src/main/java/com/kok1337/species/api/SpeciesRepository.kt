package com.kok1337.species.api

interface SpeciesRepository {
    suspend fun findAll(): List<SpeciesApiModel>
    suspend fun findAllById(ids: Iterable<Int>): List<SpeciesApiModel>
    suspend fun findById(id: Int): SpeciesApiModel
}
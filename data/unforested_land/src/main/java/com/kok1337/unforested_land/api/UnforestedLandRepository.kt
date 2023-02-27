package com.kok1337.unforested_land.api

interface UnforestedLandRepository {
    suspend fun findById(id: Int): UnforestedLandApiModel
    suspend fun findAll(): List<UnforestedLandApiModel>
    suspend fun findAllWithSearch(search: String = ""): List<UnforestedLandApiModel>
}
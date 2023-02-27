package com.kok1337.non_forest_land.api

interface NonForestLandRepository {
    suspend fun findById(id: Int): NonForestLandApiModel
    suspend fun findAll(): List<NonForestLandApiModel>
    suspend fun findAllWithSearch(search: String = ""): List<NonForestLandApiModel>
}
package com.kok1337.forest_purpose.api

interface ForestPurposeRepository {
    suspend fun findById(id: Int): ForestPurposeApiModel
    suspend fun findAll(): List<ForestPurposeApiModel>
    suspend fun findAllWithSearch(search: String = ""): List<ForestPurposeApiModel>
}
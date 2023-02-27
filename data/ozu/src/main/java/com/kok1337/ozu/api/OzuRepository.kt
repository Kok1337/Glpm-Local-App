package com.kok1337.ozu.api

interface OzuRepository {
    suspend fun findById(id: Int): OzuApiModel
    suspend fun findAll(): List<OzuApiModel>
    suspend fun findAllWithSearch(search: String = ""): List<OzuApiModel>
}
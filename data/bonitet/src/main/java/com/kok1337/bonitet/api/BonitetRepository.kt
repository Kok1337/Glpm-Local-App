package com.kok1337.bonitet.api

interface BonitetRepository {
    suspend fun findById(id: Int): BonitetApiModel
    suspend fun findAll(): List<BonitetApiModel>
    suspend fun findAllWithSearch(search: String = ""): List<BonitetApiModel>
}
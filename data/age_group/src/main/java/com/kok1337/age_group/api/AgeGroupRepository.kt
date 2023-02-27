package com.kok1337.age_group.api

interface AgeGroupRepository {
    suspend fun findById(id: Int): AgeGroupApiModel
    suspend fun findAll(): List<AgeGroupApiModel>
    suspend fun findAllWithSearch(search: String = ""): List<AgeGroupApiModel>
}
package com.kok1337.land.api

interface LandRepository {
    suspend fun findByIsForestLand(isForestLand: Boolean): LandApiModel
    suspend fun findAll(): List<LandApiModel>
}
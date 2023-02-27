package com.kok1337.land.internal.repository

import com.kok1337.land.api.LandApiModel
import com.kok1337.land.api.LandRepository

internal class LandRepositoryImpl : LandRepository {
    private val landList = listOf(
        LandApiModel("Лесные", true),
        LandApiModel("Не лесные", false),
    )

    override suspend fun findByIsForestLand(isForestLand: Boolean): LandApiModel {
        return landList.first { it.isForestLand == isForestLand }
    }

    override suspend fun findAll(): List<LandApiModel> {
        return landList
    }
}
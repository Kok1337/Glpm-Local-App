package com.kok1337.taxation.data.repository

import com.kok1337.taxation.domain.model.Land

class LandFixedRepository {
    private val hardCodedLand = listOf(
        Land("Лесные", true),
        Land("Не лесные", false)
    )

    suspend fun findByIsForestLand(isForestLand: Boolean): Land {
        return hardCodedLand.first { it.isForestLand == isForestLand }
    }

    suspend fun findAll(): Iterable<Land> {
        return hardCodedLand
    }
}
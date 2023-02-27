package com.kok1337.land.api

import com.kok1337.land.internal.repository.LandRepositoryImpl


object LandRepositoryFactory {
    fun create(): LandRepository {
        return LandRepositoryImpl()
    }
}
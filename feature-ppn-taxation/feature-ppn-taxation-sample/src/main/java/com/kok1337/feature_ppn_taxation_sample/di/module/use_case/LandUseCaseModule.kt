package com.kok1337.feature_ppn_taxation_sample.di.module.use_case

import com.kok1337.land.api.LandRepository
import com.kok1337.land.api.LandRepositoryFactory
import com.kok1337.land.api.use_case.GetAllLandUseCase
import dagger.Module
import dagger.Provides

@Module
internal interface LandUseCaseModule {
    companion object {
        @Provides
        fun landRepository(): LandRepository {
            return LandRepositoryFactory.create()
        }

        @Provides
        fun getAllLandUseCase(
            landRepository: LandRepository
        ): GetAllLandUseCase {
            return GetAllLandUseCase(landRepository)
        }
    }
}
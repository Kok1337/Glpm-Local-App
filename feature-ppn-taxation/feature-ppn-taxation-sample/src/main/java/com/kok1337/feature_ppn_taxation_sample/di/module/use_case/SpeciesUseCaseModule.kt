package com.kok1337.feature_ppn_taxation_sample.di.module.use_case

import com.kok1337.species.api.SpeciesRepository
import com.kok1337.species.api.SpeciesRepositoryFactory
import com.kok1337.species.api.use_case.GetAllSpeciesUseCase
import dagger.Module
import dagger.Provides

@Module
internal interface SpeciesUseCaseModule {
    companion object {
        @Provides
        fun speciesRepository(): SpeciesRepository {
            return SpeciesRepositoryFactory.create()
        }

        @Provides
        fun getAllSpeciesUseCase(
            speciesRepository: SpeciesRepository
        ): GetAllSpeciesUseCase {
            return GetAllSpeciesUseCase(speciesRepository)
        }
    }
}
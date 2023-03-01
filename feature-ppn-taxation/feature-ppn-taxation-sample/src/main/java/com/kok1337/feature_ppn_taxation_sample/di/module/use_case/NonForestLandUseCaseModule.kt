package com.kok1337.feature_ppn_taxation_sample.di.module.use_case

import com.kok1337.non_forest_land.api.NonForestLandDependencies
import com.kok1337.non_forest_land.api.NonForestLandRepository
import com.kok1337.non_forest_land.api.NonForestLandRepositoryFactory
import com.kok1337.non_forest_land.api.use_case.GetAllNonForestLandBySearchUseCase
import dagger.Module
import dagger.Provides
import org.springframework.jdbc.core.JdbcTemplate

@Module
internal interface NonForestLandUseCaseModule {
    companion object {
        @Provides
        fun nonForestLandRepository(jdbcTemplate: JdbcTemplate): NonForestLandRepository {
            return NonForestLandRepositoryFactory.create(object : NonForestLandDependencies {
                override val jdbcTemplate: JdbcTemplate get() = jdbcTemplate
            })
        }

        @Provides
        fun getAllNonForestLandBySearchUseCase(
            nonForestLandRepository: NonForestLandRepository
        ): GetAllNonForestLandBySearchUseCase {
            return GetAllNonForestLandBySearchUseCase(nonForestLandRepository)
        }
    }
}
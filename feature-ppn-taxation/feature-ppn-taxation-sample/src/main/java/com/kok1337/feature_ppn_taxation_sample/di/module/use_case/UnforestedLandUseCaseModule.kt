package com.kok1337.feature_ppn_taxation_sample.di.module.use_case

import com.kok1337.unforested_land.api.UnforestedLandDependencies
import com.kok1337.unforested_land.api.UnforestedLandRepository
import com.kok1337.unforested_land.api.UnforestedLandRepositoryFactory
import com.kok1337.unforested_land.api.use_case.GetAllUnforestedLandBySearchUseCase
import dagger.Module
import dagger.Provides
import org.springframework.jdbc.core.JdbcTemplate

@Module
internal interface UnforestedLandUseCaseModule {
    companion object {
        @Provides
        fun unforestedLandRepository(jdbcTemplate: JdbcTemplate): UnforestedLandRepository {
            return UnforestedLandRepositoryFactory.create(object : UnforestedLandDependencies {
                override val jdbcTemplate: JdbcTemplate get() = jdbcTemplate
            })
        }

        @Provides
        fun getAllUnforestedLandBySearchUseCase(
            unforestedLandRepository: UnforestedLandRepository
        ): GetAllUnforestedLandBySearchUseCase {
            return GetAllUnforestedLandBySearchUseCase(unforestedLandRepository)
        }
    }
}
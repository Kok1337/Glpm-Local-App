package com.kok1337.feature_ppn_taxation_sample.di.module.use_case

import com.kok1337.forest_purpose.api.ForestPurposeDependencies
import com.kok1337.forest_purpose.api.ForestPurposeRepository
import com.kok1337.forest_purpose.api.ForestPurposeRepositoryFactory
import com.kok1337.forest_purpose.api.use_case.GetAllForestPurposeBySearchUseCase
import dagger.Module
import dagger.Provides
import org.springframework.jdbc.core.JdbcTemplate

@Module
internal interface ForestPurposeUseCaseModule {
    companion object {
        @Provides
        fun forestPurposeRepository(jdbcTemplate: JdbcTemplate): ForestPurposeRepository {
            return ForestPurposeRepositoryFactory.create(object : ForestPurposeDependencies {
                override val jdbcTemplate: JdbcTemplate get() = jdbcTemplate
            })
        }

        @Provides
        fun getAllForestPurposeBySearchUseCase(
            forestPurposeRepository: ForestPurposeRepository
        ): GetAllForestPurposeBySearchUseCase {
            return GetAllForestPurposeBySearchUseCase(forestPurposeRepository)
        }
    }
}
package com.kok1337.feature_ppn_taxation_sample.di.module.use_case

import com.kok1337.bonitet.api.BonitetDependencies
import com.kok1337.bonitet.api.BonitetRepository
import com.kok1337.bonitet.api.BonitetRepositoryFactory
import com.kok1337.bonitet.api.use_case.GetAllBonitetBySearchUseCase
import dagger.Module
import dagger.Provides
import org.springframework.jdbc.core.JdbcTemplate

@Module
internal interface BonitetUseCaseModule {
    companion object {
        @Provides
        fun bonitetRepository(jdbcTemplate: JdbcTemplate): BonitetRepository {
            return BonitetRepositoryFactory.create(object : BonitetDependencies {
                override val jdbcTemplate: JdbcTemplate get() = jdbcTemplate
            })
        }

        @Provides
        fun getAllBonitetBySearchUseCase(
            bonitetRepository: BonitetRepository
        ): GetAllBonitetBySearchUseCase {
            return GetAllBonitetBySearchUseCase(bonitetRepository)
        }
    }
}
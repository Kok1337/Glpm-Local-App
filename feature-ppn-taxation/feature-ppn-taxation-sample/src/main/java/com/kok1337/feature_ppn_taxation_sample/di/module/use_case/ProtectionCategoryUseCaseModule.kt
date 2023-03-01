package com.kok1337.feature_ppn_taxation_sample.di.module.use_case

import com.kok1337.protection_category.api.ProtectionCategoryDependencies
import com.kok1337.protection_category.api.ProtectionCategoryRepository
import com.kok1337.protection_category.api.ProtectionCategoryRepositoryFactory
import com.kok1337.protection_category.api.use_case.GetAllProtectionCategoryBySearchUseCase
import dagger.Module
import dagger.Provides
import org.springframework.jdbc.core.JdbcTemplate

@Module
internal interface ProtectionCategoryUseCaseModule {
    companion object {
        @Provides
        fun ProtectionCategoryRepository(jdbcTemplate: JdbcTemplate): ProtectionCategoryRepository {
            return ProtectionCategoryRepositoryFactory.create(object :
                ProtectionCategoryDependencies {
                override val jdbcTemplate: JdbcTemplate get() = jdbcTemplate
            })
        }

        @Provides
        fun getAllProtectionCategoryBySearchUseCase(
            protectionCategoryRepository: ProtectionCategoryRepository
        ): GetAllProtectionCategoryBySearchUseCase {
            return GetAllProtectionCategoryBySearchUseCase(protectionCategoryRepository)
        }
    }
}
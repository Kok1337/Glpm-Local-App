package com.kok1337.feature_ppn_taxation_sample.di.module.use_case

import com.kok1337.ozu.api.OzuDependencies
import com.kok1337.ozu.api.OzuRepository
import com.kok1337.ozu.api.OzuRepositoryFactory
import com.kok1337.ozu.api.use_case.GetAllOzuBySearchUseCase
import dagger.Module
import dagger.Provides
import org.springframework.jdbc.core.JdbcTemplate

@Module
internal interface OzuUseCaseModule {
    companion object {
        @Provides
        fun ozuRepository(jdbcTemplate: JdbcTemplate): OzuRepository {
            return OzuRepositoryFactory.create(object : OzuDependencies {
                override val jdbcTemplate: JdbcTemplate get() = jdbcTemplate
            })
        }

        @Provides
        fun getAllOzuBySearchUseCase(
            ozuRepository: OzuRepository
        ): GetAllOzuBySearchUseCase {
            return GetAllOzuBySearchUseCase(ozuRepository)
        }
    }
}
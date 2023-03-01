package com.kok1337.feature_ppn_taxation_sample.di.module.use_case

import com.kok1337.age_group.api.AgeGroupDependencies
import com.kok1337.age_group.api.AgeGroupRepository
import com.kok1337.age_group.api.AgeGroupRepositoryFactory
import com.kok1337.age_group.api.use_case.GetAllAgeGroupBySearchUseCase
import dagger.Module
import dagger.Provides
import org.springframework.jdbc.core.JdbcTemplate

@Module
internal interface AgeGroupUseCaseModule {
    companion object {
        @Provides
        fun ageGroupRepository(jdbcTemplate: JdbcTemplate): AgeGroupRepository {
            return AgeGroupRepositoryFactory.create(object : AgeGroupDependencies {
                override val jdbcTemplate: JdbcTemplate get() = jdbcTemplate
            })
        }

        @Provides
        fun getAllAgeGroupBySearchUseCase(
            ageGroupRepository: AgeGroupRepository
        ): GetAllAgeGroupBySearchUseCase {
            return GetAllAgeGroupBySearchUseCase(ageGroupRepository)
        }
    }
}
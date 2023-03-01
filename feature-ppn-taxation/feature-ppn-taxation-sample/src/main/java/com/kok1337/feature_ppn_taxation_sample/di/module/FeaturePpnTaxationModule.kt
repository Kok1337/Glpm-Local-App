package com.kok1337.feature_ppn_taxation_sample.di.module

import com.kok1337.feature_ppn_taxation.api.dependencies.*
import com.kok1337.feature_ppn_taxation_sample.di.FeaturePpnTaxationActivityComponent
import com.kok1337.feature_ppn_taxation_sample.di.module.provider.SelectorProviderModule
import com.kok1337.providing_dependencies.Dependencies
import com.kok1337.providing_dependencies_dagger.DependenciesKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(
    includes = [
        SelectorProviderModule::class,
    ]
)
interface FeaturePpnTaxationModule {
    @Binds
    @IntoMap
    @DependenciesKey(FeaturePpnTaxationDependencies::class)
    fun bindFeaturePpnTaxationDeps(impl: FeaturePpnTaxationActivityComponent): Dependencies
}


/*
@Module
interface FeaturePpnTaxationRepositoryModule {
    companion object {
        @Provides
        fun landRepository(): LandRepository {
            return LandRepositoryFactory.create()
        }

        @Provides
        fun unforestedLandRepository(jdbcTemplate: JdbcTemplate): UnforestedLandRepository {
            return UnforestedLandRepositoryFactory.create(object : UnforestedLandDependencies {
                override val jdbcTemplate: JdbcTemplate get() = jdbcTemplate
            })
        }

        @Provides
        fun nonForestLandRepository(jdbcTemplate: JdbcTemplate): NonForestLandRepository {
            return NonForestLandRepositoryFactory.create(object : NonForestLandDependencies {
                override val jdbcTemplate: JdbcTemplate get() = jdbcTemplate
            })
        }

        @Provides
        fun forestPurposeRepository(jdbcTemplate: JdbcTemplate): ForestPurposeRepository {
            return ForestPurposeRepositoryFactory.create(object : ForestPurposeDependencies {
                override val jdbcTemplate: JdbcTemplate get() = jdbcTemplate
            })
        }

        @Provides
        fun protectionCategoryRepository(jdbcTemplate: JdbcTemplate): ProtectionCategoryRepository {
            return ProtectionCategoryRepositoryFactory.create(object :
                ProtectionCategoryDependencies {
                override val jdbcTemplate: JdbcTemplate get() = jdbcTemplate
            })
        }

        @Provides
        fun bonitetRepository(jdbcTemplate: JdbcTemplate): BonitetRepository {
            return BonitetRepositoryFactory.create(object : BonitetDependencies {
                override val jdbcTemplate: JdbcTemplate get() = jdbcTemplate
            })
        }

        @Provides
        fun ozuRepository(jdbcTemplate: JdbcTemplate): OzuRepository {
            return OzuRepositoryFactory.create(object : OzuDependencies {
                override val jdbcTemplate: JdbcTemplate get() = jdbcTemplate
            })
        }
    }
}

@Module
interface FeaturePpnTaxationUseCaseModule {
    companion object {
        @Provides
        fun getAllLandUseCase(landRepository: LandRepository): GetAllLandUseCase {
            return GetAllLandUseCase(landRepository)
        }

        @Provides
        fun getAllUnforestedLandBySearchUseCase(unforestedLandRepository: UnforestedLandRepository): GetAllUnforestedLandBySearchUseCase {
            return GetAllUnforestedLandBySearchUseCase(unforestedLandRepository)
        }

        @Provides
        fun getAllNonForestLandBySearchUseCase(nonForestLandRepository: NonForestLandRepository): GetAllNonForestLandBySearchUseCase {
            return GetAllNonForestLandBySearchUseCase(nonForestLandRepository)
        }

        @Provides
        fun getAllForestPurposeBySearchUseCase(forestPurposeRepository: ForestPurposeRepository): GetAllForestPurposeBySearchUseCase {
            return GetAllForestPurposeBySearchUseCase(forestPurposeRepository)
        }

        @Provides
        fun getAllProtectionCategoryBySearchUseCase(protectionCategoryRepository: ProtectionCategoryRepository): GetAllProtectionCategoryBySearchUseCase {
            return GetAllProtectionCategoryBySearchUseCase(protectionCategoryRepository)
        }

        @Provides
        fun getAllBonitetBySearchUseCase(bonitetRepository: BonitetRepository): GetAllBonitetBySearchUseCase {
            return GetAllBonitetBySearchUseCase(bonitetRepository)
        }

        @Provides
        fun getAllOzuBySearchUseCase(ozuRepository: OzuRepository): GetAllOzuBySearchUseCase {
            return GetAllOzuBySearchUseCase(ozuRepository)
        }
    }
}

@Module
interface FeaturePpnTaxationSpinnerRepositoryModule {
    companion object {
        @Provides
        fun landSpinnerRepository(
            getAllLandUseCase: GetAllLandUseCase,
        ): SearchableSpinnerRepository<Land> = SearchableSpinnerRepository { _, _ ->
            getAllLandUseCase()
        }

        @Provides
        fun unforestedLandSpinnerRepository(
            getAllUnforestedLandBySearchUseCase: GetAllUnforestedLandBySearchUseCase,
        ): SearchableSpinnerRepository<UnforestedLand> = SearchableSpinnerRepository { search, _ ->
            getAllUnforestedLandBySearchUseCase(search)
        }

        @Provides
        fun nonForestLandSpinnerRepository(
            getAllNonForestLandBySearchUseCase: GetAllNonForestLandBySearchUseCase,
        ): SearchableSpinnerRepository<NonForestLand> = SearchableSpinnerRepository { search, _ ->
            getAllNonForestLandBySearchUseCase(search)
        }

        @Provides
        fun forestPurposeSpinnerRepository(
            getAllForestPurposeBySearchUseCase: GetAllForestPurposeBySearchUseCase,
        ): SearchableSpinnerRepository<ForestPurpose> = SearchableSpinnerRepository { search, _ ->
            getAllForestPurposeBySearchUseCase(search)
        }

        @Provides
        fun protectionCategorySpinnerRepository(
            getAllProtectionCategoryBySearchUseCase: GetAllProtectionCategoryBySearchUseCase,
        ): SearchableSpinnerRepository<ProtectionCategory> =
            SearchableSpinnerRepository { search, _ ->
                getAllProtectionCategoryBySearchUseCase(search)
            }

        @Provides
        fun bonitetSpinnerRepository(
            getAllBonitetBySearchUseCase: GetAllBonitetBySearchUseCase,
        ): SearchableSpinnerRepository<Bonitet> = SearchableSpinnerRepository { search, _ ->
            getAllBonitetBySearchUseCase(search)
        }

        @Provides
        fun ozuSpinnerRepository(
            getAllOzuBySearchUseCase: GetAllOzuBySearchUseCase,
        ): SearchableSpinnerRepository<Ozu> = SearchableSpinnerRepository { search, _ ->
            getAllOzuBySearchUseCase(search)
        }
    }
}*/


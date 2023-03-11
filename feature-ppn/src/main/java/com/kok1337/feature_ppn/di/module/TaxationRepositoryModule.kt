package com.kok1337.feature_ppn.di.module

import com.kok1337.feature_ppn.di.FeaturePpnFragmentScope
import com.kok1337.taxation.data.data_source.termux.dao.*
import com.kok1337.taxation.data.repository.*
import com.kok1337.termux_database.api.DatabaseFactory
import dagger.Module
import dagger.Provides

@Module
object TaxationRepositoryModule {
    @[FeaturePpnFragmentScope Provides]
    fun ageGroupDao(
        databaseFactory: DatabaseFactory,
    ): AgeGroupDao = AgeGroupDao(
        databaseFactory = databaseFactory,
    )

    @[FeaturePpnFragmentScope Provides]
    fun bonitetDao(
        databaseFactory: DatabaseFactory,
    ): BonitetDao = BonitetDao(
        databaseFactory = databaseFactory,
    )

    @[FeaturePpnFragmentScope Provides]
    fun forestPurposeDao(
        databaseFactory: DatabaseFactory,
    ): ForestPurposeDao = ForestPurposeDao(
        databaseFactory = databaseFactory,
    )

    @[FeaturePpnFragmentScope Provides]
    fun nonForestLandDao(
        databaseFactory: DatabaseFactory,
    ): NonForestLandDao = NonForestLandDao(
        databaseFactory = databaseFactory,
    )

    @[FeaturePpnFragmentScope Provides]
    fun ozuDao(
        databaseFactory: DatabaseFactory,
    ): OzuDao = OzuDao(
        databaseFactory = databaseFactory,
    )

    @[FeaturePpnFragmentScope Provides]
    fun protectionCategoryDao(
        databaseFactory: DatabaseFactory,
    ): ProtectionCategoryDao = ProtectionCategoryDao(
        databaseFactory = databaseFactory,
    )

    @[FeaturePpnFragmentScope Provides]
    fun taxDao(
        databaseFactory: DatabaseFactory,
    ): TaxDao = TaxDao(
        databaseFactory = databaseFactory,
    )

    @[FeaturePpnFragmentScope Provides]
    fun taxLayerDao(
        databaseFactory: DatabaseFactory,
    ): TaxLayerDao = TaxLayerDao(
        databaseFactory = databaseFactory,
    )

    @[FeaturePpnFragmentScope Provides]
    fun taxSourceDao(
        databaseFactory: DatabaseFactory,
    ): TaxSourceDao = TaxSourceDao(
        databaseFactory = databaseFactory,
    )

    @[FeaturePpnFragmentScope Provides]
    fun taxSpeciesDao(
        databaseFactory: DatabaseFactory,
    ): TaxSpeciesDao = TaxSpeciesDao(
        databaseFactory = databaseFactory,
    )

    @[FeaturePpnFragmentScope Provides]
    fun unforestedLandDao(
        databaseFactory: DatabaseFactory,
    ): UnforestedLandDao = UnforestedLandDao(
        databaseFactory = databaseFactory,
    )

    @[FeaturePpnFragmentScope Provides]
    fun ageGroupTermuxRepository(
        ageGroupDao: AgeGroupDao,
    ): AgeGroupTermuxRepository = AgeGroupTermuxRepository(
        ageGroupDao = ageGroupDao,
    )

    @[FeaturePpnFragmentScope Provides]
    fun bonitetTermuxRepository(
        bonitetDao: BonitetDao,
    ): BonitetTermuxRepository = BonitetTermuxRepository(
        bonitetDao = bonitetDao,
    )

    @[FeaturePpnFragmentScope Provides]
    fun forestPurposeTermuxRepository(
        forestPurposeDao: ForestPurposeDao,
    ): ForestPurposeTermuxRepository = ForestPurposeTermuxRepository(
        forestPurposeDao = forestPurposeDao,
    )

    @[FeaturePpnFragmentScope Provides]
    fun nonForestLandTermuxRepository(
        nonForestLandDao: NonForestLandDao,
    ): NonForestLandTermuxRepository = NonForestLandTermuxRepository(
        nonForestLandDao = nonForestLandDao,
    )

    @[FeaturePpnFragmentScope Provides]
    fun ozuTermuxRepository(
        ozuDao: OzuDao,
    ): OzuTermuxRepository = OzuTermuxRepository(
        ozuDao = ozuDao,
    )

    @[FeaturePpnFragmentScope Provides]
    fun protectionCategoryTermuxRepository(
        protectionCategoryDao: ProtectionCategoryDao,
    ): ProtectionCategoryTermuxRepository = ProtectionCategoryTermuxRepository(
        protectionCategoryDao = protectionCategoryDao
    )

    @[FeaturePpnFragmentScope Provides]
    fun taxLayerTermuxRepository(
        taxLayerDao: TaxLayerDao,
        taxSpeciesTermuxRepository: TaxSpeciesTermuxRepository,
        ageGroupTermuxRepository: AgeGroupTermuxRepository,
    ): TaxLayerTermuxRepository = TaxLayerTermuxRepository(
        taxLayerDao = taxLayerDao,
        taxSpeciesTermuxRepository = taxSpeciesTermuxRepository,
        ageGroupTermuxRepository = ageGroupTermuxRepository,
    )

    @[FeaturePpnFragmentScope Provides]
    fun taxPreviewTermuxRepository(
        taxDao: TaxDao,
        taxSourceTermuxRepository: TaxSourceTermuxRepository,
    ): TaxPreviewTermuxRepository = TaxPreviewTermuxRepository(
        taxDao = taxDao,
        taxSourceTermuxRepository = taxSourceTermuxRepository,
    )

    @[FeaturePpnFragmentScope Provides]
    fun taxSourceTermuxRepository(
        taxSourceDao: TaxSourceDao,
    ): TaxSourceTermuxRepository = TaxSourceTermuxRepository(
        taxSourceDao = taxSourceDao
    )

    @[FeaturePpnFragmentScope Provides]
    fun taxSpeciesTermuxRepository(
        taxSpeciesDao: TaxSpeciesDao,
    ): TaxSpeciesTermuxRepository = TaxSpeciesTermuxRepository(
        taxSpeciesDao = taxSpeciesDao,
    )

    @[FeaturePpnFragmentScope Provides]
    fun taxTermuxRepository(
        taxDao: TaxDao,
        taxLayerTermuxRepository: TaxLayerTermuxRepository,
        forestPurposeTermuxRepository: ForestPurposeTermuxRepository,
        protectionCategoryTermuxRepository: ProtectionCategoryTermuxRepository,
        ozuTermuxRepository: OzuTermuxRepository,
        bonitetTermuxRepository: BonitetTermuxRepository,
        nonForestLandTermuxRepository: NonForestLandTermuxRepository,
        unforestedLandTermuxRepository: UnforestedLandTermuxRepository,
        taxSourceTermuxRepository: TaxSourceTermuxRepository,
    ): TaxTermuxRepository = TaxTermuxRepository(
        taxDao = taxDao,
        taxLayerTermuxRepository = taxLayerTermuxRepository,
        forestPurposeTermuxRepository = forestPurposeTermuxRepository,
        protectionCategoryTermuxRepository = protectionCategoryTermuxRepository,
        ozuTermuxRepository = ozuTermuxRepository,
        bonitetTermuxRepository = bonitetTermuxRepository,
        nonForestLandTermuxRepository = nonForestLandTermuxRepository,
        unforestedLandTermuxRepository = unforestedLandTermuxRepository,
        taxSourceTermuxRepository = taxSourceTermuxRepository,
    )

    @[FeaturePpnFragmentScope Provides]
    fun unforestedLandTermuxRepository(
        unforestedLandDao: UnforestedLandDao,
    ): UnforestedLandTermuxRepository = UnforestedLandTermuxRepository(
        unforestedLandDao = unforestedLandDao,
    )

    @[FeaturePpnFragmentScope Provides]
    fun landFixedRepository(): LandFixedRepository = LandFixedRepository()
}
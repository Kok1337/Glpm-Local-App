package com.kok1337.feature_ppn.di.module

import com.kok1337.address.data.data_source.termux.dao.*
import com.kok1337.address.data.repository.*
import com.kok1337.feature_ppn.di.FeaturePpnFragmentScope
import com.kok1337.termux_database.api.DatabaseFactory
import dagger.Module
import dagger.Provides

@Module
internal object AddressRepositoryModule {
    @[FeaturePpnFragmentScope Provides]
    fun localityDao(
        databaseFactory: DatabaseFactory,
    ): LocalityDao = LocalityDao(
        databaseFactory = databaseFactory,
    )

    @[FeaturePpnFragmentScope Provides]
    fun federalDistrictDao(
        databaseFactory: DatabaseFactory,
    ): FederalDistrictDao = FederalDistrictDao(
        databaseFactory = databaseFactory,
    )

    @[FeaturePpnFragmentScope Provides]
    fun regionDao(
        databaseFactory: DatabaseFactory,
    ): RegionDao = RegionDao(
        databaseFactory = databaseFactory,
    )

    @[FeaturePpnFragmentScope Provides]
    fun forestryDao(
        databaseFactory: DatabaseFactory,
    ): ForestryDao = ForestryDao(
        databaseFactory = databaseFactory,
    )

    @[FeaturePpnFragmentScope Provides]
    fun localForestryDao(
        databaseFactory: DatabaseFactory,
    ): LocalForestryDao = LocalForestryDao(
        databaseFactory = databaseFactory,
    )

    @[FeaturePpnFragmentScope Provides]
    fun subForestryDao(
        databaseFactory: DatabaseFactory,
    ): SubForestryDao = SubForestryDao(
        databaseFactory = databaseFactory,
    )

    @[FeaturePpnFragmentScope Provides]
    fun federalDistrictTermuxRepository(
        federalDistrictDao: FederalDistrictDao,
        localityDao: LocalityDao,
    ): FederalDistrictTermuxRepository = FederalDistrictTermuxRepository(
        federalDistrictDao = federalDistrictDao,
        localityDao = localityDao,
    )

    @[FeaturePpnFragmentScope Provides]
    fun regionTermuxRepository(
        regionDao: RegionDao,
        localityDao: LocalityDao,
    ): RegionTermuxRepository = RegionTermuxRepository(
        regionDao = regionDao,
        localityDao = localityDao,
    )

    @[FeaturePpnFragmentScope Provides]
    fun forestryTermuxRepository(
        forestryDao: ForestryDao,
        localityDao: LocalityDao,
    ): ForestryTermuxRepository = ForestryTermuxRepository(
        forestryDao = forestryDao,
        localityDao = localityDao,
    )

    @[FeaturePpnFragmentScope Provides]
    fun localForestryTermuxRepository(
        localForestryDao: LocalForestryDao,
        localityDao: LocalityDao,
    ): LocalForestryTermuxRepository = LocalForestryTermuxRepository(
        localForestryDao = localForestryDao,
        localityDao = localityDao,
    )

    @[FeaturePpnFragmentScope Provides]
    fun subForestryTermuxRepository(
        subForestryDao: SubForestryDao,
        localityDao: LocalityDao,
    ): SubForestryTermuxRepository = SubForestryTermuxRepository(
        subForestryDao = subForestryDao,
        localityDao = localityDao,
    )

    @[FeaturePpnFragmentScope Provides]
    fun localityTermuxRepository(
        localityDao: LocalityDao,
        federalDistrictTermuxRepository: FederalDistrictTermuxRepository,
        regionTermuxRepository: RegionTermuxRepository,
        forestryTermuxRepository: ForestryTermuxRepository,
        localForestryTermuxRepository: LocalForestryTermuxRepository,
        subForestryTermuxRepository: SubForestryTermuxRepository,
    ): LocalityTermuxRepository = LocalityTermuxRepository(
        localityDao = localityDao,
        federalDistrictTermuxRepository = federalDistrictTermuxRepository,
        regionTermuxRepository = regionTermuxRepository,
        forestryTermuxRepository = forestryTermuxRepository,
        localForestryTermuxRepository = localForestryTermuxRepository,
        subForestryTermuxRepository = subForestryTermuxRepository,
    )
}
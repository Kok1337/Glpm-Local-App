package com.kok1337.feature_ppn.di.module

import com.kok1337.feature_ppn.di.FeaturePpnFragmentScope
import com.kok1337.species.data.repository.SpeciesFixedRepository
import dagger.Module
import dagger.Provides

@Module
internal object SpeciesRepositoryModule {
    @[FeaturePpnFragmentScope Provides]
    fun speciesFixedRepository(): SpeciesFixedRepository = SpeciesFixedRepository()
}
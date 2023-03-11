package com.kok1337.feature_ppn.di.module

import com.kok1337.feature_ppn.di.FeaturePpnFragmentComponent
import com.kok1337.feature_ppn_taxation.di.FeaturePpnTaxationFragmentDeps
import com.kok1337.providing_dependencies.Dependencies
import com.kok1337.providing_dependencies_dagger.DependenciesKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface FeaturePpnTaxationFragmentDepsModule {
    @Binds
    @IntoMap
    @DependenciesKey(FeaturePpnTaxationFragmentDeps::class)
    fun bindFeaturePpnTaxationFragmentDeps(impl: FeaturePpnFragmentComponent): Dependencies
}
package com.kok1337.feature_ppn_description_sample.di

import com.kok1337.feature_ppn_description.di.FeaturePpnDescriptionFragmentDeps
import com.kok1337.providing_dependencies.Dependencies
import com.kok1337.providing_dependencies_dagger.DependenciesKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface PpnDescriptionFragmentModule {
    @Binds
    @IntoMap
    @DependenciesKey(FeaturePpnDescriptionFragmentDeps::class)
    fun bindFeature1Deps(impl: FeaturePpnDescriptionFragmentActivityComponent): Dependencies
}
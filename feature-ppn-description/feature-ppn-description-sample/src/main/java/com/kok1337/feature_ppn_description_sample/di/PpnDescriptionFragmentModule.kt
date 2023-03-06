package com.kok1337.feature_ppn_description_sample.di

import com.kok1337.feature_ppn_description.api.PpnDescriptionDeps
import com.kok1337.feature_ppn_description_sample.presentation.FeaturePpnDescriptionActivity
import com.kok1337.providing_dependencies.Dependencies
import com.kok1337.providing_dependencies_dagger.DependenciesKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface PpnDescriptionFragmentModule {
    @Binds
    @IntoMap
    @DependenciesKey(PpnDescriptionDeps::class)
    fun bindFeature1Deps(impl: PpnDescriptionActivityComponent): Dependencies
}
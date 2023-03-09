package com.kok1337.feature_ppn_description_sample.di

import com.kok1337.feature_ppn_description.di.LocalityInMemoryRepository
import com.kok1337.feature_ppn_description.di.FeaturePpnDescriptionFragmentDeps
import com.kok1337.feature_ppn_description_sample.presentation.FeaturePpnDescriptionActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [PpnDescriptionActivityDeps::class],
    modules = [PpnDescriptionFragmentModule::class]
)
internal interface FeaturePpnDescriptionFragmentActivityComponent : FeaturePpnDescriptionFragmentDeps {
    @Component.Factory
    interface Factory {
        fun create(
            deps: PpnDescriptionActivityDeps,
            @BindsInstance localityInMemoryRepository: LocalityInMemoryRepository,
        ): FeaturePpnDescriptionFragmentActivityComponent
    }

    fun inject(activity: FeaturePpnDescriptionActivity)
}
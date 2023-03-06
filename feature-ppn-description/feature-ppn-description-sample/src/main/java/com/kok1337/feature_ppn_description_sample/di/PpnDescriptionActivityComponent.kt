package com.kok1337.feature_ppn_description_sample.di

import com.kok1337.feature_ppn_description.api.AddressInMemoryRepository
import com.kok1337.feature_ppn_description.api.PpnDescriptionDeps
import com.kok1337.feature_ppn_description_sample.presentation.FeaturePpnDescriptionActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [PpnDescriptionActivityDeps::class],
    modules = [PpnDescriptionFragmentModule::class]
)
internal interface PpnDescriptionActivityComponent : PpnDescriptionDeps {
    @Component.Factory
    interface Factory {
        fun create(
            deps: PpnDescriptionActivityDeps,
            @BindsInstance addressInMemoryRepository: AddressInMemoryRepository,
        ): PpnDescriptionActivityComponent
    }

    fun inject(activity: FeaturePpnDescriptionActivity)
}
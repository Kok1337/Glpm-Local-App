package com.kok1337.feature_ppn.di

import com.kok1337.feature_ppn.di.module.AddressRepositoryModule
import com.kok1337.feature_ppn.di.module.FeaturePpnDescriptionFragmentDepsModule
import com.kok1337.feature_ppn.di.module.TaxationRepositoryModule
import com.kok1337.feature_ppn.presentation.fragment.PpnFragment
import com.kok1337.feature_ppn_description.data.repository.LocalityInMemoryRepository
import com.kok1337.feature_ppn_description.data.repository.TaxInMemoryRepository
import com.kok1337.feature_ppn_description.di.FeaturePpnDescriptionFragmentDeps
import dagger.BindsInstance
import dagger.Component

@[FeaturePpnFragmentScope Component(
    dependencies = [FeaturePpnFragmentDeps::class],
    modules = [
        AddressRepositoryModule::class,
        TaxationRepositoryModule::class,
        FeaturePpnDescriptionFragmentDepsModule::class,
    ]
)]
internal interface FeaturePpnFragmentComponent : FeaturePpnDescriptionFragmentDeps {
    @Component.Factory
    interface Factory {
        fun create(
            featurePpnFragmentDeps: FeaturePpnFragmentDeps,
            @BindsInstance localityInMemoryRepository: LocalityInMemoryRepository,
            @BindsInstance taxInMemoryRepository: TaxInMemoryRepository,
        ): FeaturePpnFragmentComponent
    }

    fun inject(ppnFragment: PpnFragment)
}
package com.kok1337.feature_ppn.di

import com.kok1337.feature_ppn.di.module.*
import com.kok1337.feature_ppn.presentation.fragment.PpnFragment
import com.kok1337.feature_ppn_description.data.repository.DescriptionLocalityInMemoryRepository
import com.kok1337.feature_ppn_description.data.repository.DescriptionTaxInMemoryRepository
import com.kok1337.feature_ppn_description.di.FeaturePpnDescriptionFragmentDeps
import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxInMemoryRepository
import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxLayerInMemoryRepository
import com.kok1337.feature_ppn_taxation.data.repository.TaxationTaxSpeciesInMemoryRepository
import com.kok1337.feature_ppn_taxation.di.FeaturePpnTaxationFragmentDeps
import dagger.BindsInstance
import dagger.Component

@[FeaturePpnFragmentScope Component(
    dependencies = [FeaturePpnFragmentDeps::class],
    modules = [
        AddressRepositoryModule::class,
        TaxationRepositoryModule::class,
        SpeciesRepositoryModule::class,
        FeaturePpnDescriptionFragmentDepsModule::class,
        FeaturePpnTaxationFragmentDepsModule::class,
    ]
)]
internal interface FeaturePpnFragmentComponent : FeaturePpnDescriptionFragmentDeps,
    FeaturePpnTaxationFragmentDeps {
    @Component.Factory
    interface Factory {
        fun create(
            featurePpnFragmentDeps: FeaturePpnFragmentDeps,
            @BindsInstance descriptionLocalityInMemoryRepository: DescriptionLocalityInMemoryRepository,
            @BindsInstance descriptionTaxInMemoryRepository: DescriptionTaxInMemoryRepository,
            @BindsInstance taxationTaxInMemoryRepository: TaxationTaxInMemoryRepository,
            @BindsInstance taxationTaxLayerInMemoryRepository: TaxationTaxLayerInMemoryRepository,
            @BindsInstance taxationTaxSpeciesInMemoryRepository: TaxationTaxSpeciesInMemoryRepository,
        ): FeaturePpnFragmentComponent
    }

    fun inject(ppnFragment: PpnFragment)
}
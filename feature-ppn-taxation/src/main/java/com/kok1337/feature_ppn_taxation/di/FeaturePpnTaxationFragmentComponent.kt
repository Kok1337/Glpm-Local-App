package com.kok1337.feature_ppn_taxation.di

import com.kok1337.feature_ppn_taxation.presentation.fragment.PpnTaxationFragment
import dagger.Component

@Component(dependencies = [FeaturePpnTaxationFragmentDeps::class])
internal interface FeaturePpnTaxationFragmentComponent {
    @Component.Factory
    interface Factory {
        fun create(dependencies: FeaturePpnTaxationFragmentDeps): FeaturePpnTaxationFragmentComponent
    }

    fun inject(fragment: PpnTaxationFragment)
}
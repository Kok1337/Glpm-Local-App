package com.kok1337.feature_ppn_taxation.internal.di

import com.kok1337.feature_ppn_taxation.api.dependencies.FeaturePpnTaxationDependencies
import com.kok1337.feature_ppn_taxation.api.fragment.PpnTaxationFragment
import dagger.Component

@Component(dependencies = [FeaturePpnTaxationDependencies::class])
internal interface FeaturePpnTaxationComponent {
    @Component.Factory
    interface Factory {
        fun create(dependencies: FeaturePpnTaxationDependencies): FeaturePpnTaxationComponent
    }

    fun inject(fragment: PpnTaxationFragment)
}
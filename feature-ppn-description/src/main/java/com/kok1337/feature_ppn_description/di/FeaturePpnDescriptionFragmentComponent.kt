package com.kok1337.feature_ppn_description.di

import com.kok1337.feature_ppn_description.presentation.fragment.PpnDescriptionFragment
import dagger.Component

@Component(dependencies = [FeaturePpnDescriptionFragmentDeps::class])
internal interface FeaturePpnDescriptionFragmentComponent {
    @Component.Factory
    interface Factory {
        fun create(featurePpnDescriptionFragmentDeps: FeaturePpnDescriptionFragmentDeps): FeaturePpnDescriptionFragmentComponent
    }

    fun inject(ppnDescriptionFragment: PpnDescriptionFragment)
}
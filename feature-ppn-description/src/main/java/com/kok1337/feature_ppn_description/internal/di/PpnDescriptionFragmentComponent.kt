package com.kok1337.feature_ppn_description.internal.di

import com.kok1337.feature_ppn_description.PpnDescriptionFragment
import com.kok1337.feature_ppn_description.api.PpnDescriptionDeps
import dagger.Component

@Component(dependencies = [PpnDescriptionDeps::class])
interface PpnDescriptionFragmentComponent {
    @Component.Factory
    interface Factory {
        fun create(deps: PpnDescriptionDeps): PpnDescriptionFragmentComponent
    }

    fun inject(ppnDescriptionFragment: PpnDescriptionFragment)
}
package com.kok1337.feature_ppn_taxation_sample.di.module.provider

import com.kok1337.feature_ppn_taxation.api.dependencies.*
import com.kok1337.feature_ppn_taxation_sample.di.module.selector.LandSelectorModule
import com.kok1337.feature_ppn_taxation_sample.di.module.selector.TaxLayerSelectorModule
import com.kok1337.feature_ppn_taxation_sample.di.module.selector.TaxLayerSpeciesSelectorModule
import com.kok1337.feature_ppn_taxation_sample.di.module.selector.TaxSelectorModule
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        LandSelectorModule::class,
        TaxSelectorModule::class,
        TaxLayerSelectorModule::class,
        TaxLayerSpeciesSelectorModule::class,
    ]
)
internal interface SelectorProviderModule {
    companion object {
        @Provides
        fun selectorProvider(
            landSelector: LandSelector,
            taxSelector: TaxSelector,
            taxLayerSelector: TaxLayerSelector,
            taxLayerSpeciesSelector: TaxLayerSpeciesSelector,
        ): SelectorProvider = object : SelectorProvider {
            override fun getLandSelector(): LandSelector =
                landSelector

            override fun getTaxSelector(): TaxSelector =
                taxSelector

            override fun getTaxLayerSelector(): TaxLayerSelector =
                taxLayerSelector

            override fun getTaxLayerSpeciesSelector(): TaxLayerSpeciesSelector =
                taxLayerSpeciesSelector
        }
    }
}
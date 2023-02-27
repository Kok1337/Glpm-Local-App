package com.kok1337.feature_ppn_taxation_sample.di.module.provider

import com.kok1337.feature_ppn_taxation.api.dependencies.*
import dagger.Module
import dagger.Provides

@Module
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
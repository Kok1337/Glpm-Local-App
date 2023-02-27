package com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listener

import com.kok1337.tax_layer_species.api.model.TaxLayerSpecies

internal interface TaxLayerSpeciesListener {
    fun onDeleteTaxLayerSpeciesClick(taxLayerSpecies: TaxLayerSpecies)
}
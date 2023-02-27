package com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listener

import com.kok1337.tax_layer.api.model.TaxLayer

internal interface TaxLayerListener {
    fun onDeleteTaxLayerClick(taxLayer: TaxLayer)
}
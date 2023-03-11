package com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.listener

import com.kok1337.species.domain.model.Species
import java.util.*

internal interface TaxSpeciesListener {
    fun onSpeciesClick(taxLayerSpeciesId: UUID, species: Species?)
    fun onCoeffClick(taxLayerSpeciesId: UUID, coeff: Int?)
    fun onAgeClick(taxLayerSpeciesId: UUID, age: Int?)
    fun onTaxLayerSpeciesHeightClick(taxLayerSpeciesId: UUID, height: Int?)
    fun onDiameterClick(taxLayerSpeciesId: UUID, diameter: Int?)
    fun onDeleteTaxLayerSpeciesClick(taxLayerSpeciesId: UUID)
}
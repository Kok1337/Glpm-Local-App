package com.kok1337.feature_ppn_taxation.data.repository

import com.kok1337.species.domain.model.Species
import java.util.*

interface TaxationTaxSpeciesInMemoryRepository {
    fun updateCoeff(taxSpeciesId: UUID, coeff: Int?)
    fun updateSpecies(taxSpeciesId: UUID, species: Species?)
    fun updateAge(taxSpeciesId: UUID, age: Int?)
    fun updateHeight(taxSpeciesId: UUID, height: Int?)
    fun updateDiameter(taxSpeciesId: UUID, diameter: Int?)
    fun deleteTaxLayerSpecies(taxSpeciesId: UUID)
}
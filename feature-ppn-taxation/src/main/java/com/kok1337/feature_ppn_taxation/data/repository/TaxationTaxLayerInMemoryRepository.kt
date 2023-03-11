package com.kok1337.feature_ppn_taxation.data.repository

import com.kok1337.taxation.domain.model.AgeGroup
import java.util.*

interface TaxationTaxLayerInMemoryRepository {
    fun updateHeight(taxLayerId: UUID, height: Int?)
    fun updateAgeClass(taxLayerId: UUID, ageClass: Int?)
    fun updateAgeGroup(taxLayerId: UUID, ageGroup: AgeGroup?)
    fun updateFullness(taxLayerId: UUID, fullness: Double?)
    fun updateStock(taxLayerId: UUID, stock: Double?)
    fun addTaxSpecies(taxLayerId: UUID)
    fun deleteTaxLayer(taxLayerId: UUID)
}
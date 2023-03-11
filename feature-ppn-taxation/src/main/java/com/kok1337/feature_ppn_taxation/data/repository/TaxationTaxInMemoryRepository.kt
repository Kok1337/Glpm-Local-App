package com.kok1337.feature_ppn_taxation.data.repository

import com.kok1337.taxation.domain.model.*
import kotlinx.coroutines.flow.StateFlow

interface TaxationTaxInMemoryRepository {
    fun getTaxStateFlow(): StateFlow<Tax?>
    fun updateUnforestedLand(unforestedLand: UnforestedLand?)
    fun updateNonForestLand(nonForestLand: NonForestLand?)
    fun updateForestPurpose(forestPurpose: ForestPurpose?)
    fun updateProtectionCategory(protectionCategory: ProtectionCategory?)
    fun updateBonitet(bonitet: Bonitet?)
    fun updateForestType(forestType: String?)
    fun updateOzu(ozu: Ozu?)
    fun addTaxLayer()
}
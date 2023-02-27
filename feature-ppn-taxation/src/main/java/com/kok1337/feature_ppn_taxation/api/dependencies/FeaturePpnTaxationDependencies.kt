package com.kok1337.feature_ppn_taxation.api.dependencies

import com.kok1337.age_group.api.model.AgeGroup
import com.kok1337.bonitet.api.model.Bonitet
import com.kok1337.forest_purpose.api.model.ForestPurpose
import com.kok1337.land.api.model.Land
import com.kok1337.non_forest_land.api.model.NonForestLand
import com.kok1337.ozu.api.model.Ozu
import com.kok1337.protection_category.api.model.ProtectionCategory
import com.kok1337.providing_dependencies.Dependencies
import com.kok1337.species.api.model.Species
import com.kok1337.tax.api.model.Tax
import com.kok1337.unforested_land.api.model.UnforestedLand
import kotlinx.coroutines.flow.StateFlow
import java.util.*

interface FeaturePpnTaxationDependencies : Dependencies {
    val taxStateFlowProvider: TaxStateFlowProvider
    val redactorProvider: RedactorProvider
    val selectorProvider: SelectorProvider
}

interface TaxStateFlowProvider {
    fun get(): StateFlow<Tax>
}

interface RedactorProvider {
    fun getTaxRedactor(): TaxRedactor
    fun getTaxLayerRedactor(): TaxLayerRedactor
    fun getTaxLayerSpeciesRedactor(): TaxLayerSpeciesRedactor
}

interface SelectorProvider {
    fun getLandSelector(): LandSelector
    fun getTaxSelector(): TaxSelector
    fun getTaxLayerSelector(): TaxLayerSelector
    fun getTaxLayerSpeciesSelector(): TaxLayerSpeciesSelector
}

interface TaxRedactor {
    suspend fun updateUnforestedLand(unforestedLand: UnforestedLand?)
    suspend fun updateNonForestLand(nonForestLand: NonForestLand?)
    suspend fun updateForestPurpose(forestPurpose: ForestPurpose?)
    suspend fun updateProtectionCategory(protectionCategory: ProtectionCategory?)
    suspend fun updateBonitet(bonitet: Bonitet)
    suspend fun updateForestType(forestType: String?)
    suspend fun updateOzu(ozu: Ozu?)
    suspend fun addTaxLayer()
}

interface TaxLayerRedactor {
    suspend fun updateHeight(taxLayerId: UUID, height: Int?)
    suspend fun updateAgeClass(taxLayerId: UUID, ageClass: Int?)
    suspend fun updateAgeGroup(taxLayerId: UUID, ageGroup: AgeGroup?)
    suspend fun updateFullness(taxLayerId: UUID, fullness: Double?)
    suspend fun updateStock(taxLayerId: UUID, stock: Double?)
    suspend fun addTaxLayerSpecies(taxLayerId: UUID)
    suspend fun deleteTaxLayer(taxLayerId: UUID)
}

interface TaxLayerSpeciesRedactor {
    suspend fun updateCoeff(taxLayerSpeciesId: UUID, coeff: Int?)
    suspend fun updateSpecies(taxLayerSpeciesId: UUID, species: Species?)
    suspend fun updateAge(taxLayerSpeciesId: UUID, age: Int?)
    suspend fun updateHeight(taxLayerSpeciesId: UUID, height: Int?)
    suspend fun updateDiameter(taxLayerSpeciesId: UUID, diameter: Int?)
    suspend fun deleteTaxLayerSpecies(taxLayerSpeciesId: UUID)
}

interface LandSelector {
    suspend fun selectLand(
        currentLand: Land?,
        onLandSelected: (Land?) -> Unit
    )
}

interface TaxSelector {
    suspend fun selectUnforestedLand(
        currentUnforestedLand: UnforestedLand?,
        onUnforestedLandSelected: (UnforestedLand?) -> Unit
    )

    suspend fun selectNonForestLand(
        currentNonForestLand: NonForestLand?,
        onNonForestLandSelected: (NonForestLand?) -> Unit
    )

    suspend fun selectForestPurpose(
        currentForestPurpose: ForestPurpose?,
        onForestPurposeSelected: (ForestPurpose?) -> Unit
    )

    suspend fun selectProtectionCategory(
        currentProtectionCategory: ProtectionCategory?,
        onProtectionCategorySelected: (ProtectionCategory?) -> Unit
    )

    suspend fun selectBonitet(
        currentBonitet: Bonitet?,
        onBonitetSelected: (Bonitet?) -> Unit
    )

    suspend fun selectForestType(
        currentForestType: String?,
        onForestTypeSelected: (String?) -> Unit
    )

    suspend fun selectOzu(
        currentOzu: String?,
        onOzuSelected: (Ozu?) -> Unit
    )
}

interface TaxLayerSelector {
    suspend fun selectHeight(
        currentHeight: Int?,
        onHeightSelected: (Int?) -> Unit
    )

    suspend fun selectAgeClass(
        currentAgeClass: Int?,
        onAgeClassSelected: (Int?) -> Unit
    )

    suspend fun selectAgeGroup(
        currentAgeGroup: Int?,
        onAgeGroupSelected: (AgeGroup?) -> Unit
    )

    suspend fun selectFullness(
        currentFullness: Int?,
        onFullnessSelected: (Double?) -> Unit
    )

    suspend fun selectStock(
        currentStock: Int?,
        onStockSelected: (Double?) -> Unit
    )
}

interface TaxLayerSpeciesSelector {
    suspend fun selectCoeff(
        currentCoeff: Int?,
        onCoeffSelected: (Int?) -> Unit
    )

    suspend fun selectSpecies(
        currentSpecies: Species?,
        onSpeciesSelected: (Species?) -> Unit
    )

    suspend fun selectAge(
        currentAge: Int?,
        onAgeSelected: (Int?) -> Unit
    )

    suspend fun selectHeight(
        currentHeight: Int?,
        onHeightSelected: (Int?) -> Unit
    )

    suspend fun selectDiameter(
        currentDiameter: Int?,
        onDiameterSelected: (Int?) -> Unit
    )
}


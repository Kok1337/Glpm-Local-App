package com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter

import com.kok1337.feature_ppn_taxation.presentation.adapter.taxation_item_adapter.item.*
import com.kok1337.taxation.domain.model.Land
import com.kok1337.taxation.domain.model.Tax
import com.kok1337.taxation.domain.model.TaxLayer
import com.kok1337.taxation.domain.model.TaxSpecies
import java.util.*

internal object TaxationItemTransformer {
    fun transformToTaxationItemList(
        tax: Tax?,
        isCoveredForest: Boolean,
        land: Land?
    ): List<TaxationItem> {
        if (tax == null) return emptyList()

        val listItemList = ArrayList<TaxationItem>()
        listItemList.add(taxToTaxItem(tax, isCoveredForest, land))
        tax.taxLayerList.forEachIndexed { index, taxLayer ->
            listItemList.add(taxLayerToTaxLayerItem(taxLayer, index + 1))
            listItemList.addAll(taxLayer.taxSpeciesList.map { taxLayerSpecies ->
                val speciesStock = taxLayerSpecies.coeff?.let { taxLayer.stock?.div(10)?.times(it) }
                taxSpeciesToTaxSpeciesItem(taxLayerSpecies, speciesStock)
            })
            listItemList.add(createAddTaxSpeciesItem(taxLayer.id))
        }
        listItemList.add(createAddTaxLayerItem(tax.id))
        return listItemList
    }

    private fun taxToTaxItem(tax: Tax, isCoveredForest: Boolean, land: Land?): TaxItem {
        return TaxItem(
            taxId = tax.id,
            isCoveredForest = isCoveredForest,
            land = land,
            nonForestLand = tax.nonForestLand,
            unforestedLand = tax.unforestedLand,
            forestPurpose = tax.forestPurpose,
            protectionCategory = tax.protectionCategory,
            bonitet = tax.bonitet,
            forestType = tax.forestType,
            ozu = tax.ozu
        )
    }

    private fun taxLayerToTaxLayerItem(taxLayer: TaxLayer, taxLayerNumber: Int): TaxLayerItem {
        return TaxLayerItem(
            taxLayerId = taxLayer.id,
            taxLayerNum = taxLayerNumber,
            composition = taxLayer.composition,
            height = taxLayer.height,
            ageClass = taxLayer.ageClass,
            ageGroup = taxLayer.ageGroup,
            fullness = taxLayer.fullness,
            stock = taxLayer.stock,
        )
    }

    private fun taxSpeciesToTaxSpeciesItem(
        taxLayerSpecies: TaxSpecies,
        stock: Double?
    ): TaxSpeciesItem {
        return TaxSpeciesItem(
            taxLayerSpeciesId = taxLayerSpecies.id,
            stock = stock,
            species = taxLayerSpecies.species,
            coeff = taxLayerSpecies.coeff,
            age = taxLayerSpecies.age,
            height = taxLayerSpecies.height,
            diameter = taxLayerSpecies.diameter,
        )
    }

    private fun createAddTaxLayerItem(taxId: UUID): AddTaxLayerItem {
        return AddTaxLayerItem(taxId)
    }

    private fun createAddTaxSpeciesItem(taxLayerId: UUID): AddTaxSpeciesItem {
        return AddTaxSpeciesItem(taxLayerId)
    }
}
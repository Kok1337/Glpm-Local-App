package com.kok1337.feature_ppn_taxation.internal.presentation.item

import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listitem_adapter.ListItem
import com.kok1337.land.api.model.Land
import com.kok1337.tax.api.model.Tax
import com.kok1337.tax_layer.api.model.TaxLayer
import com.kok1337.tax_layer_species.api.model.TaxLayerSpecies
import java.util.*

internal object ItemTransformer {
    fun transformToListItemList(tax: Tax, isCoveredForest: Boolean, land: Land?): List<ListItem> {
        val listItemList = ArrayList<ListItem>()
        listItemList.add(taxToTaxItem(tax, isCoveredForest, land))
        tax.taxLayerList.forEachIndexed { index, taxLayer ->
            listItemList.add(taxLayerToTaxLayerItem(taxLayer, index + 1))
            listItemList.addAll(taxLayer.taxLayerSpeciesList.map { taxLayerSpecies ->
                val speciesStock = taxLayerSpecies.coeff?.let { taxLayer.stock?.div(10)?.times(it) }
                taxLayerSpeciesToTaxLayerSpeciesItem(taxLayerSpecies, speciesStock)
            })
            listItemList.add(createAddTaxLayerSpeciesItem(taxLayer.id))
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

    private fun taxLayerSpeciesToTaxLayerSpeciesItem(
        taxLayerSpecies: TaxLayerSpecies,
        stock: Double?
    ): TaxLayerSpeciesItem {
        return TaxLayerSpeciesItem(
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

    private fun createAddTaxLayerSpeciesItem(taxLayerId: UUID): AddTaxLayerSpeciesItem {
        return AddTaxLayerSpeciesItem(taxLayerId)
    }
}
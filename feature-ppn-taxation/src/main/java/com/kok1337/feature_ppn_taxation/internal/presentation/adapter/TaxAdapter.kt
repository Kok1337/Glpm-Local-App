package com.kok1337.feature_ppn_taxation.internal.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.kok1337.common_diff_callback.CommonCallbackImpl
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.delegate.*
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listener.AdapterListener
import com.kok1337.feature_ppn_taxation.internal.presentation.item.*

internal class TaxAdapter(
    adapterListener: AdapterListener,
) : ListDelegationAdapter<List<ListItem>>() {
    init {
        delegatesManager.addDelegate(TaxItemDelegate(adapterListener))
        delegatesManager.addDelegate(TaxLayerItemDelegate(adapterListener))
        delegatesManager.addDelegate(TaxLayerSpeciesItemDelegate(adapterListener))
        delegatesManager.addDelegate(AddTaxLayerItemDelegate(adapterListener))
        delegatesManager.addDelegate(AddTaxLayerSpeciesItemDelegate(adapterListener))
    }

    fun setTaxItem(taxItem: TaxItem) {
        val expandedTax = ArrayList<ListItem>()
        expandedTax.add(taxItem)
        taxItem.tax.taxLayerList.forEachIndexed { index, taxLayer ->
            expandedTax.add(TaxLayerItem(taxLayer, index + 1))
            expandedTax.addAll(taxLayer.taxLayerSpeciesList.map { taxLayerSpecies ->
                val speciesStock = taxLayerSpecies.coeff?.let { taxLayer.stock?.div(10)?.times(it) }
                TaxLayerSpeciesItem(taxLayerSpecies, speciesStock)
            })
            expandedTax.add(AddTaxLayerSpeciesItem(taxLayer.id))
        }
        expandedTax.add(AddTaxLayerItem(taxItem.tax.id))
        setExpandedList(expandedTax)
    }

    private fun setExpandedList(newItems: List<ListItem>) {
        val oldItems = this.items ?: emptyList()
        val diffResult: DiffUtil.DiffResult = calculateDiff(oldItems, newItems)
        diffResult.dispatchUpdatesTo(this)
        super.setItems(newItems)
    }

    private fun calculateDiff(
        oldItems: List<ListItem>,
        newItems: List<ListItem>
    ): DiffUtil.DiffResult {
        val commonCallbackImpl = CommonCallbackImpl(
            oldItems,
            newItems,
            ::areItemsTheSameImpl,
            ::areContentsTheSame
        )
        return DiffUtil.calculateDiff(commonCallbackImpl)
    }

    private fun areItemsTheSameImpl(oldItem: ListItem, newItem: ListItem): Boolean {
        if (oldItem is TaxItem && newItem is TaxItem) {
            return oldItem.tax.id == newItem.tax.id
        }
        if (oldItem is TaxLayerItem && newItem is TaxLayerItem) {
            return oldItem.taxLayer.id == newItem.taxLayer.id
        }
        if (oldItem is TaxLayerSpeciesItem && newItem is TaxLayerSpeciesItem) {
            return oldItem.taxLayerSpecies.id == newItem.taxLayerSpecies.id
        }
        if (oldItem is AddTaxLayerItem && newItem is AddTaxLayerItem) {
            return oldItem.taxId == newItem.taxId
        }
        if (oldItem is AddTaxLayerSpeciesItem && newItem is AddTaxLayerSpeciesItem) {
            return oldItem.taxLayerId == newItem.taxLayerId
        }
        return false
    }

    private fun areContentsTheSame(oldItem: ListItem, newItem: ListItem): Boolean {
//        return oldItem == newItem
        /*if (oldItem is TaxItem && newItem is TaxItem) {
            return oldItem.isCoveredForest == newItem.isCoveredForest &&
                    oldItem.land == newItem.land &&
                    oldItem.forestPurpose == newItem.forestPurpose &&
                    oldItem.nonForestLand == newItem.nonForestLand &&
                    oldItem.unforestedLand == newItem.unforestedLand &&
                    oldItem.protectionCategory == newItem.protectionCategory &&
                    oldItem.bonitet == newItem.bonitet &&
                    oldItem.forestType == newItem.forestType &&
                    oldItem.ozu == newItem.ozu
        }
        if (oldItem is TaxLayerItem && newItem is TaxLayerItem) {
            return oldItem.taxLayerNum == newItem.taxLayerNum &&
                    oldItem.composition == newItem.composition &&
                    oldItem.height == newItem.height &&
                    oldItem.ageClass == newItem.ageClass &&
                    oldItem.ageGroup == newItem.ageGroup &&
                    oldItem.fullness == newItem.stock &&
                    oldItem.taxLayerSpeciesCount == newItem.taxLayerSpeciesCount
        }
        if (oldItem is TaxLayerSpeciesItem && newItem is TaxLayerSpeciesItem) {
            return oldItem.stock == newItem.stock &&
                    oldItem.species == newItem.species &&
                    oldItem.coeff == newItem.coeff &&
                    oldItem.age == newItem.age &&
                    oldItem.height == newItem.height &&
                    oldItem.diameter == newItem.diameter
        }
        if (oldItem is AddTaxLayerItem && newItem is AddTaxLayerItem) {
            return oldItem.taxId == newItem.taxId
        }
        if (oldItem is AddTaxLayerSpeciesItem && newItem is AddTaxLayerSpeciesItem) {
            return oldItem.taxLayerId == newItem.taxLayerId
        }
        return false*/

        if (oldItem is TaxItem && newItem is TaxItem) {
            return oldItem == newItem
        }
        if (oldItem is TaxLayerItem && newItem is TaxLayerItem) {
            return oldItem == newItem
        }
        if (oldItem is TaxLayerSpeciesItem && newItem is TaxLayerSpeciesItem) {
            return oldItem == newItem
        }
        if (oldItem is AddTaxLayerItem && newItem is AddTaxLayerItem) {
            return oldItem == newItem
        }
        if (oldItem is AddTaxLayerSpeciesItem && newItem is AddTaxLayerSpeciesItem) {
            return oldItem == newItem
        }
        return false
    }
}
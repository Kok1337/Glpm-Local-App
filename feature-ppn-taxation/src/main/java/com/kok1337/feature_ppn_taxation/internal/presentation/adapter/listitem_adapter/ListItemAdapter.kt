package com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listitem_adapter

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.kok1337.common_diff_callback.CommonCallbackImpl
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listitem_adapter.delegate.*
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listitem_adapter.listener.AdapterListener
import com.kok1337.feature_ppn_taxation.internal.presentation.item.*

internal class ListItemAdapter(
    adapterListener: AdapterListener,
) : ListDelegationAdapter<List<ListItem>>() {
    init {
        delegatesManager.addDelegate(TaxItemDelegate(adapterListener))
        delegatesManager.addDelegate(TaxLayerItemDelegate(adapterListener))
        delegatesManager.addDelegate(TaxLayerSpeciesItemDelegate(adapterListener))
        delegatesManager.addDelegate(AddTaxLayerItemDelegate(adapterListener))
        delegatesManager.addDelegate(AddTaxLayerSpeciesItemDelegate(adapterListener))
    }

    override fun setItems(items: List<ListItem>?) {
        val oldItems = this.items ?: emptyList()
        val newItems = items ?: emptyList()
        val diffResult: DiffUtil.DiffResult = calculateDiff(oldItems, newItems)
        diffResult.dispatchUpdatesTo(this)
        super.setItems(items)
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
            return oldItem.taxId == newItem.taxId
        }
        if (oldItem is TaxLayerItem && newItem is TaxLayerItem) {
            return oldItem.taxLayerId == newItem.taxLayerId
        }
        if (oldItem is TaxLayerSpeciesItem && newItem is TaxLayerSpeciesItem) {
            return oldItem.taxLayerSpeciesId == newItem.taxLayerSpeciesId
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
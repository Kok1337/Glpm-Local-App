package com.kok1337.feature_ppn_taxation.internal.presentation.adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.kok1337.feature_ppn_taxation.databinding.ItemTaxLayerBinding
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.ListItem
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listener.AddTaxLayerListener
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listener.TaxLayerListener
import com.kok1337.feature_ppn_taxation.internal.presentation.item.TaxLayerItem

internal class TaxLayerItemDelegate(
    private val taxLayerListener: TaxLayerListener,
) :
    AbsListItemAdapterDelegate<TaxLayerItem, ListItem, TaxLayerItemDelegate.TaxLayerItemViewHolder>() {
    inner class TaxLayerItemViewHolder(val binding: ItemTaxLayerBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun isForViewType(
        item: ListItem,
        items: MutableList<ListItem>,
        position: Int
    ): Boolean = item is TaxLayerItem

    override fun onCreateViewHolder(parent: ViewGroup): TaxLayerItemViewHolder {
        val binding =
            ItemTaxLayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaxLayerItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        item: TaxLayerItem,
        holder: TaxLayerItemViewHolder,
        payloads: MutableList<Any>
    ) {
        val binding = holder.binding
        val taxLayer = item.taxLayer
        val layerNum = item.taxLayerNum

        binding.taxLayerNumberTextView.text = "Ярус $layerNum"
        binding.taxLayerDeleteButton.setOnClickListener {
            taxLayerListener.onDeleteTaxLayerClick(taxLayer)
        }
    }
}
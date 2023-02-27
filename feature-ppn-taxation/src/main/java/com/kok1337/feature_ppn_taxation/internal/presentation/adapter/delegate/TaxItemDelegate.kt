package com.kok1337.feature_ppn_taxation.internal.presentation.adapter.delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.kok1337.feature_ppn_taxation.databinding.ItemTaxBinding
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.ListItem
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listener.TaxListener
import com.kok1337.feature_ppn_taxation.internal.presentation.item.TaxItem

internal class TaxItemDelegate(
    private val taxListener: TaxListener,
) :
    AbsListItemAdapterDelegate<TaxItem, ListItem, TaxItemDelegate.TaxItemViewHolder>() {
    inner class TaxItemViewHolder(val binding: ItemTaxBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun isForViewType(
        item: ListItem,
        items: MutableList<ListItem>,
        position: Int
    ): Boolean = item is TaxItem

    override fun onCreateViewHolder(parent: ViewGroup): TaxItemViewHolder {
        val binding =
            ItemTaxBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaxItemViewHolder(binding)
    }

    override fun onBindViewHolder(
        item: TaxItem,
        holder: TaxItemViewHolder,
        payloads: MutableList<Any>
    ) {
        val binding = holder.binding
        val tax = item.tax

        binding.notCoveredForestCheckBox.isChecked = !item.isCoveredForest
        binding.coveredLayout.visibility = if (item.isCoveredForest) View.VISIBLE else View.GONE
        binding.notCoveredLayout.visibility = if (!item.isCoveredForest) View.VISIBLE else View.GONE
        binding.notCoveredForestCheckBox.setOnCheckedChangeListener { _, isNotCoveredForest ->
            taxListener.onNotCoveredForestClick(!isNotCoveredForest)
        }

        binding.landSpinner.text = item.land?.name ?: ""
        binding.landSpinner.setOnClickListener {
            taxListener.onLandClick(item.land)
        }


        val landCategoryText = item.land?.let {
            if (it.isForestLand) tax.nonForestLand?.name else tax.unforestedLand?.name
        }
        binding.landCategorySpinner.isEnabled = item.land != null
        binding.landCategorySpinner.text = landCategoryText ?: ""
        binding.landCategorySpinner.setOnClickListener {
            val isForestLand = item.land?.isForestLand ?: false
            if (isForestLand) taxListener.onNonForestLandClick(tax)
            else taxListener.onUnforestedLandClick(tax)
        }


        binding.targetCategorySpinner.text = tax.forestPurpose?.name ?: ""
        binding.targetCategorySpinner.setOnClickListener {
            taxListener.onForestPurposeClick(tax)
        }
        binding.protectionCategorySpinner.isEnabled = tax.forestPurpose?.name == "защитные"
        binding.protectionCategorySpinner.text = tax.protectionCategory?.name ?: ""
        binding.protectionCategorySpinner.setOnClickListener {
            taxListener.onProtectionCategoryClick(tax)
        }
        binding.bonitetSpinner.text = tax.bonitet?.name ?: ""
        binding.bonitetSpinner.setOnClickListener {
            taxListener.onBonitetClick(tax)
        }
        binding.forestTypeSpinner.text = tax.forestType
        binding.forestTypeSpinner.setOnClickListener {
            taxListener.onForestTypeClick(tax)
        }
        binding.ozuSpinner.text = tax.ozu?.name ?: ""
        binding.ozuSpinner.setOnClickListener {
            taxListener.onOzuClick(tax)
        }
    }

}
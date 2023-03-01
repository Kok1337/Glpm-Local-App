package com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listitem_adapter.delegate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.kok1337.extensions.showToast
import com.kok1337.feature_ppn_taxation.databinding.ItemTaxBinding
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listitem_adapter.ListItem
import com.kok1337.feature_ppn_taxation.internal.presentation.adapter.listitem_adapter.listener.TaxListener
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
            if (it.isForestLand) item.unforestedLand?.name else item.nonForestLand?.name
        }
        binding.landCategorySpinner.isEnabled = item.land != null
        binding.landCategorySpinner.text = landCategoryText ?: ""
        binding.landCategorySpinner.setOnClickListener {
            val isForestLand = item.land?.isForestLand ?: false
            if (isForestLand) taxListener.onUnforestedLandClick(item.unforestedLand)
            else taxListener.onNonForestLandClick(item.nonForestLand)
        }

        binding.targetCategorySpinner.text = item.forestPurpose?.name ?: ""
        binding.targetCategorySpinner.setOnClickListener {
            taxListener.onForestPurposeClick(item.forestPurpose)
        }
        binding.targetCategorySpinner.setOnLongClickListener {
            if (item.forestPurpose == null) return@setOnLongClickListener true
            val message = "Целевое назначение: ${item.forestPurpose.name}"
            showToast(it.context, message)
            true
        }

        binding.protectionCategorySpinner.isEnabled = item.forestPurpose?.name == "защитные"
        binding.protectionCategorySpinner.text = item.protectionCategory?.name ?: ""
        binding.protectionCategorySpinner.setOnClickListener {
            taxListener.onProtectionCategoryClick(item.protectionCategory)
        }
        binding.protectionCategorySpinner.setOnLongClickListener {
            if (item.protectionCategory == null) return@setOnLongClickListener true
            val message = "Категория защитности: ${item.protectionCategory.name}"
            showToast(it.context, message)
            true
        }

        binding.bonitetSpinner.text = item.bonitet?.name ?: ""
        binding.bonitetSpinner.setOnClickListener {
            taxListener.onBonitetClick(item.bonitet)
        }
        binding.bonitetSpinner.setOnLongClickListener {
            if (item.bonitet == null) return@setOnLongClickListener true
            val message = "Бонитет: ${item.bonitet.name}"
            showToast(it.context, message)
            true
        }

        binding.forestTypeSpinner.text = item.forestType
        binding.forestTypeSpinner.setOnClickListener {
            taxListener.onForestTypeClick(item.forestType)
        }
        binding.forestTypeSpinner.setOnLongClickListener {
            if (item.forestType == null) return@setOnLongClickListener true
            val message = "Тип леса: ${item.forestType}"
            showToast(it.context, message)
            true
        }

        binding.ozuSpinner.text = item.ozu?.name ?: ""
        binding.ozuSpinner.setOnClickListener {
            taxListener.onOzuClick(item.ozu)
        }
        binding.ozuSpinner.setOnLongClickListener {
            if (item.ozu == null) return@setOnLongClickListener true
            val message = "ОЗУ: ${item.ozu.name}"
            showToast(it.context, message)
            true
        }
    }
}
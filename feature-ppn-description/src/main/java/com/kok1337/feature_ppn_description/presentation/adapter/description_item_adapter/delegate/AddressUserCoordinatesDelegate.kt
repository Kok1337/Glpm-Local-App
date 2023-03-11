package com.kok1337.feature_ppn_description.presentation.adapter.description_item_adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import com.kok1337.feature_ppn_description.databinding.ItemAddressUserCoordinatesBinding
import com.kok1337.feature_ppn_description.presentation.adapter.description_item_adapter.DescriptionItem
import com.kok1337.feature_ppn_description.presentation.adapter.description_item_adapter.item.AddressUserCoordinatesItem
import com.kok1337.feature_ppn_description.presentation.adapter.description_item_adapter.listener.AddressUserCoordinatesListener

internal class AddressUserCoordinatesDelegate(
    private val addressUserCoordinatesListener: AddressUserCoordinatesListener,
) : AbsListItemAdapterDelegate<AddressUserCoordinatesItem, DescriptionItem, AddressUserCoordinatesDelegate.AddressUserCoordinatesViewHolder>() {
    inner class AddressUserCoordinatesViewHolder(val binding: ItemAddressUserCoordinatesBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun isForViewType(
        item: DescriptionItem,
        items: MutableList<DescriptionItem>,
        position: Int
    ): Boolean = item is AddressUserCoordinatesItem

    override fun onCreateViewHolder(parent: ViewGroup): AddressUserCoordinatesViewHolder {
        val binding = ItemAddressUserCoordinatesBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return AddressUserCoordinatesViewHolder(binding)
    }

    override fun onBindViewHolder(
        item: AddressUserCoordinatesItem,
        holder: AddressUserCoordinatesViewHolder,
        payloads: MutableList<Any>
    ) {
        val binding = holder.binding

        val federalDistrict = item.federalDistrict

        val region = item.region
        binding.subjectSpinner.text = region?.name ?: ""
        binding.subjectSpinner.isEnabled = federalDistrict != null
        binding.subjectSpinner.setOnClickListener {
            addressUserCoordinatesListener.onRegionClick(region)
        }
        binding.subjectSpinner.setOnLongClickListener {
            addressUserCoordinatesListener.onRegionLongClick(region)
            true
        }

        val forestry = item.forestry
        binding.forestrySpinner.text = forestry?.name ?: ""
        binding.forestrySpinner.isEnabled = region != null
        binding.forestrySpinner.setOnClickListener {
            addressUserCoordinatesListener.onForestryClick(forestry)
        }
        binding.forestrySpinner.setOnLongClickListener {
            addressUserCoordinatesListener.onForestryLongClick(forestry)
            true
        }

        val localForestry = item.localForestry
        binding.localForestrySpinner.text = localForestry?.name ?: ""
        binding.localForestrySpinner.isEnabled = forestry != null
        binding.localForestrySpinner.setOnClickListener {
            addressUserCoordinatesListener.onLocalForestryClick(localForestry)
        }
        binding.localForestrySpinner.setOnLongClickListener {
            addressUserCoordinatesListener.onLocalForestryLongClick(localForestry)
            true
        }

        val subForestry = item.subForestry
        binding.subForestrySpinner.text = subForestry?.name ?: ""
        binding.subForestrySpinner.isEnabled = localForestry != null
        binding.subForestrySpinner.setOnClickListener {
            addressUserCoordinatesListener.onSubForestryClick(subForestry)
        }
        binding.subForestrySpinner.setOnLongClickListener {
            addressUserCoordinatesListener.onSubForestryLongClick(subForestry)
            true
        }

        val area = item.area
        binding.areaEditText.text = area ?: ""
        binding.areaEditText.isEnabled = subForestry != null
        binding.areaEditText.setOnClickListener {
            addressUserCoordinatesListener.onAreaClick(area)
        }
        binding.areaEditText.setOnLongClickListener {
            addressUserCoordinatesListener.onAreaLongClick(area)
            true
        }

        val section = item.section
        binding.sectionEditText.isEnabled = item.isFullLocality
        binding.sectionEditText.text = section ?: ""
        binding.sectionEditText.setOnClickListener {
            addressUserCoordinatesListener.onSectionClick(section)
        }
        binding.sectionEditText.setOnLongClickListener {
            addressUserCoordinatesListener.onSectionLongClick(section)
            true
        }

        val s = item.s
        binding.sEditText.isEnabled = false
        binding.sEditText.text = s?.toString() ?: ""

        binding.lpSectionEditText.isEnabled = false
    }
}
package com.kok1337.feature_ppn_description.presentation.adapter.description_item_adapter

import com.kok1337.address.domain.model.Locality
import com.kok1337.feature_ppn_description.presentation.adapter.description_item_adapter.item.AddressUserCoordinatesItem
import com.kok1337.taxation.domain.model.Tax

internal object DescriptionItemTransformer {
    fun transformToDescriptionItemList(locality: Locality, tax: Tax?): List<DescriptionItem> {
        val addressUserCoordinatesItem = AddressUserCoordinatesItem(
            federalDistrict = locality.federalDistrict,
            region = locality.region,
            forestry = locality.forestry,
            localForestry = locality.localForestry,
            subForestry = locality.subForestry,
            area = locality.area,
            section = tax?.section,
            s = tax?.s
        )
        return listOf(addressUserCoordinatesItem)
    }
}
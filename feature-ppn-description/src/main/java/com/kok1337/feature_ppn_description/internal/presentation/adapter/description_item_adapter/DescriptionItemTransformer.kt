package com.kok1337.feature_ppn_description.internal.presentation.adapter.description_item_adapter

import com.kok1337.feature_ppn_description.api.domain.module.Address
import com.kok1337.feature_ppn_description.internal.presentation.adapter.description_item_adapter.item.AddressUserCoordinatesItem

internal object DescriptionItemTransformer {
    fun transformToDescriptionItemList(address: Address): List<DescriptionItem> {
        val addressUserCoordinatesItem = AddressUserCoordinatesItem(
            federalDistrict = address.federalDistrict,
            region = address.region,
            forestry = address.forestry,
            localForestry = address.localForestry,
            subForestry = address.subForestry,
            area = address.area,
        )

        return listOf(addressUserCoordinatesItem)
    }
}
package com.kok1337.feature_ppn_description.presentation.adapter.description_item_adapter.listener

import com.kok1337.address.domain.model.*


internal interface AddressUserCoordinatesListener {
    fun onFederalDistrictClick(federalDistrict: FederalDistrict?)
    fun onRegionClick(region: Region?)
    fun onForestryClick(forestry: Forestry?)
    fun onLocalForestryClick(localForestry: LocalForestry?)
    fun onSubForestryClick(subForestry: SubForestry?)
    fun onAreaClick(area: String?)
}
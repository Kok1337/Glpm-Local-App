package com.kok1337.feature_ppn_description.presentation.adapter.description_item_adapter.listener

import com.kok1337.address.domain.model.*


internal interface AddressUserCoordinatesListener {
    fun onFederalDistrictClick(federalDistrict: FederalDistrict?)
    fun onFederalDistrictLongClick(federalDistrict: FederalDistrict?)

    fun onRegionClick(region: Region?)
    fun onRegionLongClick(region: Region?)

    fun onForestryClick(forestry: Forestry?)
    fun onForestryLongClick(forestry: Forestry?)

    fun onLocalForestryClick(localForestry: LocalForestry?)
    fun onLocalForestryLongClick(localForestry: LocalForestry?)

    fun onSubForestryClick(subForestry: SubForestry?)
    fun onSubForestryLongClick(subForestry: SubForestry?)

    fun onAreaClick(area: String?)
    fun onAreaLongClick(area: String?)

    fun onSectionClick(section: String?)
    fun onSectionLongClick(section: String?)
}
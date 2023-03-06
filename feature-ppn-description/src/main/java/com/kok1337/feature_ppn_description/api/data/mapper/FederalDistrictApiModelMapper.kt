package com.kok1337.feature_ppn_description.api.data.mapper

import com.kok1337.feature_ppn_description.api.data.model.FederalDistrictApiModel
import com.kok1337.feature_ppn_description.api.domain.module.FederalDistrict

internal object FederalDistrictApiModelMapper {
    fun toModel(federalDistrictApiModel: FederalDistrictApiModel): FederalDistrict =
        FederalDistrict(
            id = federalDistrictApiModel.id,
            name = federalDistrictApiModel.name,
        )
}
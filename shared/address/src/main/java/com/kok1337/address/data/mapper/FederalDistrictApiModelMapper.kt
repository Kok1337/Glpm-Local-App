package com.kok1337.address.data.mapper

import com.kok1337.address.data.model.FederalDistrictApiModel
import com.kok1337.address.domain.model.FederalDistrict

internal object FederalDistrictApiModelMapper {
    fun toModel(federalDistrictApiModel: FederalDistrictApiModel): FederalDistrict =
        FederalDistrict(
            id = federalDistrictApiModel.id,
            name = federalDistrictApiModel.name,
        )
}
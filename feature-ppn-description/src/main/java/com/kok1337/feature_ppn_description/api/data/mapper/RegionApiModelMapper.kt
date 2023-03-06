package com.kok1337.feature_ppn_description.api.data.mapper

import com.kok1337.feature_ppn_description.api.data.model.RegionApiModel
import com.kok1337.feature_ppn_description.api.domain.module.Region

internal object RegionApiModelMapper {
    fun toModel(regionApiModel: RegionApiModel): Region =
        Region(
            id = regionApiModel.id,
            name = regionApiModel.name,
        )
}
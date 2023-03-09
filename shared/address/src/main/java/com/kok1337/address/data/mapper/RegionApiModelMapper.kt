package com.kok1337.address.data.mapper

import com.kok1337.address.data.model.RegionApiModel
import com.kok1337.address.domain.model.Region

internal object RegionApiModelMapper {
    fun toModel(regionApiModel: RegionApiModel): Region =
        Region(
            id = regionApiModel.id,
            name = regionApiModel.name,
        )
}
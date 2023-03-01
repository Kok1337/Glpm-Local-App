package com.kok1337.district.internal.data_source.termux.mapper

import com.kok1337.district.api.module.District
import com.kok1337.district.internal.data_source.termux.entity.DistrictEntity

object EntityMapper {
    fun map(districtEntity: DistrictEntity): District = District(
        id = districtEntity.id!!,
        name = districtEntity.name!!,
    )
}
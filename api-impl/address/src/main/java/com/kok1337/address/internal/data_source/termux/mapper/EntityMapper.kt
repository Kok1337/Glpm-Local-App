package com.kok1337.address.internal.data_source.termux.mapper

import com.kok1337.address.api.model.*
import com.kok1337.address.internal.data_source.termux.entity.*

internal object EntityMapper {
    fun map(districtEntity: DistrictEntity): District = District(
        id = districtEntity.id!!,
        name = districtEntity.name!!,
    )

    fun map(regionEntity: RegionEntity): Region = Region(
        id = regionEntity.id!!,
        name = regionEntity.name!!,
    )

    fun map(forestryEntity: ForestryEntity): Forestry = Forestry(
        id = forestryEntity.id!!,
        name = forestryEntity.name!!,
    )

    fun map(localForestryEntity: LocalForestryEntity): LocalForestry = LocalForestry(
        id = localForestryEntity.id!!,
        name = localForestryEntity.name!!,
    )

    fun map(subForestryEntity: SubForestryEntity): SubForestry = SubForestry(
        id = subForestryEntity.id,
        name = subForestryEntity.name ?: "(Нет)",
    )

    fun map(address: Address): LocalityEntity = LocalityEntity(
        id = null,
        districtId = address.district?.id,
        regionId = address.region?.id,
        forestryId = address.forestry?.id,
        localForestryId = address.localForestry?.id,
        subForestryId = address.subForestry?.id,
        area = address.area,
    )
}
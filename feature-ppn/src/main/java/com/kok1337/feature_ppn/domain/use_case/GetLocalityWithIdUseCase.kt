package com.kok1337.feature_ppn.domain.use_case

import com.kok1337.address.data.repository.LocalityTermuxRepository
import com.kok1337.address.domain.model.Locality
import javax.inject.Inject

internal class GetLocalityWithIdUseCase @Inject constructor(
    private val localityTermuxRepository: LocalityTermuxRepository,
) {
    suspend operator fun invoke(locality: Locality): Locality {
        return localityTermuxRepository.findLocalityByLocalityFields(
            federalDistrictId = locality.federalDistrict!!.id,
            regionId = locality.region!!.id,
            forestryId = locality.forestry!!.id,
            localForestryId = locality.localForestry!!.id,
            subForestryId = locality.subForestry!!.id,
            area = locality.area!!
        )!!
    }
}
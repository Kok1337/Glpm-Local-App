package com.kok1337.ozu.api.use_case

import com.kok1337.ozu.api.OzuRepository
import com.kok1337.ozu.api.model.Ozu
import com.kok1337.ozu.internal.mapper.OzuMapper

class GetAllOzuBySearchUseCase(
    private val ozuRepository: OzuRepository,
) {
    suspend operator fun invoke(search: String): List<Ozu> {
        val apiModelList = ozuRepository.findAllWithSearch(search)
        return apiModelList.map(OzuMapper::fromApiModel)
    }
}
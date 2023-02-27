package com.kok1337.ozu.api.use_case

import com.kok1337.ozu.api.OzuRepository
import com.kok1337.ozu.api.model.Ozu
import com.kok1337.ozu.internal.mapper.OzuMapper

class GetOzuByIdUseCase(
    private val ozuRepository: OzuRepository,
) {
    suspend operator fun invoke(id: Int): Ozu {
        val apiModel = ozuRepository.findById(id)
        return OzuMapper.fromApiModel(apiModel)
    }
}
package com.kok1337.bonitet.api.use_case

import com.kok1337.bonitet.api.BonitetRepository
import com.kok1337.bonitet.api.model.Bonitet
import com.kok1337.bonitet.internal.mapper.BonitetMapper

class GetBonitetByIdUseCase(
    private val bonitetRepository: BonitetRepository,
) {
    suspend operator fun invoke(id: Int): Bonitet {
        val apiModel = bonitetRepository.findById(id)
        return BonitetMapper.fromApiModel(apiModel)
    }
}
package com.kok1337.feature_ppn.domain.use_case

import com.kok1337.taxation.data.repository.TaxTermuxRepository
import com.kok1337.taxation.domain.model.Tax
import java.util.UUID
import javax.inject.Inject

class GetTaxByIdUseCase @Inject constructor(
    private val  taxTermuxRepository: TaxTermuxRepository,
) {
    suspend operator fun invoke(id: UUID): Tax {
        return taxTermuxRepository.findById(id)
    }
}
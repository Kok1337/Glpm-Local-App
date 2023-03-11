package com.kok1337.feature_ppn_taxation.domain.use_case

import com.kok1337.taxation.data.repository.OzuTermuxRepository
import com.kok1337.taxation.domain.model.Ozu
import javax.inject.Inject

internal class GetAllOzuWithSearchUseCase @Inject constructor(
    private val ozuTermuxRepository: OzuTermuxRepository,
) {
    suspend operator fun invoke(search: String): List<Ozu> {
        return ozuTermuxRepository.findAllWithSearch(search).toList()
    }
}
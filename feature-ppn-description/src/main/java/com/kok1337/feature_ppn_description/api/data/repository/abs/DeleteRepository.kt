package com.kok1337.feature_ppn_description.api.data.repository.abs

interface DeleteRepository<ID, V> {
    suspend fun delete(apiModel: V)
    suspend fun deleteById(id: ID)
}
package com.kok1337.feature_ppn_description.api.data.repository.abs

interface SaveRepository<V> {
    suspend fun save(apiModel: V)
    suspend fun saveAll(apiModel: Iterable<V>)
}
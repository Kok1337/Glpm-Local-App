package com.kok1337.feature_ppn_description.api.data.repository.abs

interface GetRepository<ID, V> {
    suspend fun findById(id: ID): V?
    suspend fun findAll(): Iterable<V>
}
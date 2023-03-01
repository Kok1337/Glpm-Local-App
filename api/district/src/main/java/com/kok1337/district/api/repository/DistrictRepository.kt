package com.kok1337.district.api.repository

import com.kok1337.district.api.module.District

interface DistrictRepository {
    suspend fun findById(id: Int): District
    suspend fun findAll(): List<District>
    suspend fun findAllWithSearch(search: String): List<District>
}
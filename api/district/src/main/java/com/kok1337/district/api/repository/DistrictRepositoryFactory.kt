package com.kok1337.district.api.repository

interface DistrictRepositoryFactory {
    fun create(): DistrictRepository
}
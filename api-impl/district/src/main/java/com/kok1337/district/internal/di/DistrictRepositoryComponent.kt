package com.kok1337.district.internal.di

import com.kok1337.district.internal.repository.DistrictRepositoryImpl
import dagger.Component

@Component(dependencies = [DistrictRepositoryDeps::class])
internal interface DistrictRepositoryComponent {
    @Component.Factory
    interface Factory {
        fun create(deps: DistrictRepositoryDeps): DistrictRepositoryComponent
    }

    val districtRepositoryImpl: DistrictRepositoryImpl
}
package com.kok1337.address.di

import com.kok1337.address.internal.repository.AddressRepositoryImpl
import dagger.Component

@Component(dependencies = [AddressRepositoryDeps::class])
internal interface AddressRepositoryComponent {
    @Component.Factory
    interface Factory {
        fun create(deps: AddressRepositoryDeps): AddressRepositoryComponent
    }

    val addressRepositoryImpl: AddressRepositoryImpl
}
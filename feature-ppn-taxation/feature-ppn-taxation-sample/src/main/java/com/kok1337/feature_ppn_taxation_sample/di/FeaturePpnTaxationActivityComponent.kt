package com.kok1337.feature_ppn_taxation_sample.di

import android.content.Context
import com.kok1337.feature_ppn_taxation.api.dependencies.FeaturePpnTaxationDependencies
import com.kok1337.feature_ppn_taxation.api.dependencies.RedactorProvider
import com.kok1337.feature_ppn_taxation.api.dependencies.TaxStateFlowProvider
import com.kok1337.feature_ppn_taxation_sample.FeaturePpnTaxationActivity
import com.kok1337.feature_ppn_taxation_sample.di.module.FeaturePpnTaxationModule
import dagger.BindsInstance
import dagger.Component
import org.springframework.jdbc.core.JdbcTemplate
import javax.inject.Scope

@Scope
annotation class FeaturePpnTaxationActivityScope

@[FeaturePpnTaxationActivityScope Component(
    modules = [FeaturePpnTaxationModule::class],
)]
interface FeaturePpnTaxationActivityComponent : FeaturePpnTaxationDependencies {
    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            @BindsInstance jdbcTemplate: JdbcTemplate,
            @BindsInstance taxStateFlowProvider: TaxStateFlowProvider,
            @BindsInstance redactorProvider: RedactorProvider,
        ): FeaturePpnTaxationActivityComponent
    }

    fun inject(activity: FeaturePpnTaxationActivity)
}
package com.kok1337.tax_layer_species

import com.kok1337.database.api.JdbcTemplateDatasourceProvider
import com.kok1337.database.api.JdbcTemplateDependencies
import com.kok1337.database.api.JdbcTemplateFactory
import com.kok1337.tax_layer_species.api.TaxLayerSpeciesDependencies
import com.kok1337.tax_layer_species.api.TaxLayerSpeciesRepositoryFactory
import com.kok1337.tax_layer_species.api.UserIdProvider
import org.springframework.jdbc.core.JdbcTemplate
import java.util.*

internal fun main() {
    val jdbcTemplateDependencies = object : JdbcTemplateDependencies {
        override val jdbcTemplateDatasourceProvider: JdbcTemplateDatasourceProvider
            get() = object : JdbcTemplateDatasourceProvider {
                override val host: String get() = "127.0.0.1"
                override val port: String get() = "5432"
                override val name: String get() = "glpm_local"
                override val username: String get() = "postgres"
                override val password: String get() = "postgres"
                override val driverName: String get() = "org.postgresql.Driver"
            }
    }
    val jdbcTemplate = JdbcTemplateFactory.create(jdbcTemplateDependencies)

    val taxLayerSpeciesDependencies = object : TaxLayerSpeciesDependencies {
        override val jdbcTemplate: JdbcTemplate get() = jdbcTemplate
        override val userIdProvider: UserIdProvider
            get() = object : UserIdProvider {
                override val userId: Int get() = 2
            }
    }
    val taxLayerSpeciesRepository =
        TaxLayerSpeciesRepositoryFactory.create(taxLayerSpeciesDependencies)

    println(taxLayerSpeciesRepository)
}
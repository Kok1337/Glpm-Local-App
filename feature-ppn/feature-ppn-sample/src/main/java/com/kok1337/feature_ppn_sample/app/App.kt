package com.kok1337.feature_ppn_sample.app

import android.app.Application
import com.kok1337.feature_ppn.di.FeaturePpnFragmentDeps
import com.kok1337.providing_dependencies.DepsMap
import com.kok1337.providing_dependencies.HasDependencies
import com.kok1337.termux_database.api.DatabaseFactory
import org.ktorm.database.Database
import org.ktorm.support.postgresql.PostgreSqlDialect

class App : Application(), HasDependencies {
    inner class FeaturePpnFragmentDepsImpl : FeaturePpnFragmentDeps {
        override val databaseFactory: DatabaseFactory
            get() = object : DatabaseFactory {
                private val host = "127.0.0.1"
                private val port = "5432"
                private val name = "glpm_local"
                private val url = "jdbc:postgresql://${host}:${port}/${name}"
                private val user = "postgres"
                private val password = "postgres"
                private val driver = "org.postgresql.Driver"
                private val dialect = PostgreSqlDialect()

                private var database: Database? = null

                override fun create(): Database {
                    if (database == null) {
                        database = Database.connect(
                            url = url,
                            driver = driver,
                            user = user,
                            password = password,
                            dialect = dialect,
                            alwaysQuoteIdentifiers = true,
                            generateSqlInUpperCase = true,
                        )
                    }
                    return database!!
                }
            }

    }

    override val depsMap: DepsMap
        get() = mapOf(
            FeaturePpnFragmentDeps::class.java to FeaturePpnFragmentDepsImpl()
        )
}
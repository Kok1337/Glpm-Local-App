package com.kok1337.feature_ppn_description_sample.app

import android.app.Application
import android.util.Log
import com.kok1337.feature_ppn_description.api.data.data_source.termux.DatabaseFactory
import com.kok1337.feature_ppn_description.api.data.data_source.termux.dao.LocalityDao
import com.kok1337.feature_ppn_description.api.data.repository.LocalityTermuxRepository
import com.kok1337.feature_ppn_description.api.data.repository.LocalityTermuxRepository_Factory
import com.kok1337.feature_ppn_description_sample.di.PpnDescriptionActivityDeps
import com.kok1337.providing_dependencies.DepsMap
import com.kok1337.providing_dependencies.HasDependencies
import org.ktorm.database.Database
import org.ktorm.support.postgresql.PostgreSqlDialect

class App : Application(), HasDependencies {
    internal inner class DatabaseFactoryImpl : DatabaseFactory {
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

    override fun onCreate() {
        super.onCreate()
        Log.e("FeaturePpnDescriptionApp", "onCreate")
    }

    inner class PpnDescriptionActivityDepsImpl() : PpnDescriptionActivityDeps {
        override val databaseFactory: DatabaseFactory get() = DatabaseFactoryImpl()
    }

    override val depsMap: DepsMap
        get() = mapOf(
            PpnDescriptionActivityDeps::class.java to PpnDescriptionActivityDepsImpl(),
        )
}
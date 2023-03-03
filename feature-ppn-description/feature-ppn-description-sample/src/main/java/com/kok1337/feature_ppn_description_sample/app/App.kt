package com.kok1337.feature_ppn_description_sample.app

import android.app.Application
import android.util.Log
import com.kok1337.feature_ppn_description.api.DatabaseFactory
import org.ktorm.database.Database
import org.ktorm.support.postgresql.PostgreSqlDialect

class App : Application() {
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
}
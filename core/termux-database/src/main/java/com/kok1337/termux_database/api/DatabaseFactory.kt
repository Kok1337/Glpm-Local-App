package com.kok1337.termux_database.api

import org.ktorm.database.Database

interface DatabaseFactory {
    fun create(): Database
}
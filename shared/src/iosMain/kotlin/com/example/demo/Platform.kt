package com.example.demo

import com.poke.db.AppDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier


class IOSPlatform: Platform {
    override val name: String = "HOLA ME TIRABA ERROR Y PUSE ESTO"
}

actual fun getPlatform(): Platform = IOSPlatform()
actual fun initLogger(){
    Napier.base(DebugAntilog())
}

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(AppDatabase.Schema, "poke.db")
    }
}
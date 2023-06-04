package com.example.demo

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier


class IOSPlatform: Platform {
    override val name: String = "HOLA ME TIRABA ERROR Y PUSE ESTO"
}

actual fun getPlatform(): Platform = IOSPlatform()
actual fun initLogger(){
    Napier.base(DebugAntilog())
}
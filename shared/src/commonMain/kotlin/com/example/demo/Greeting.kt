package com.example.demo

import com.example.demo.Platform
import com.example.demo.getPlatform

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}
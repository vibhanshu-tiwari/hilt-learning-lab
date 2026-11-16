package com.vibh.hiltlearninglab.core.logger

import javax.inject.Inject

class ConsoleLogger @Inject constructor() : Logger{
    override fun log(message: String) {
        println("Console Logger: $message")
    }
}
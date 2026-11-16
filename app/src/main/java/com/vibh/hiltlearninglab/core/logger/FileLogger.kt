package com.vibh.hiltlearninglab.core.logger

import javax.inject.Inject

class FileLogger @Inject constructor(): Logger{
    override fun log(message: String) {
        println("File Logger: $message")
    }
}
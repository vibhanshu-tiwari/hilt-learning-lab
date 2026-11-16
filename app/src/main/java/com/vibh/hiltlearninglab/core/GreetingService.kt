package com.vibh.hiltlearninglab.core

import com.vibh.hiltlearninglab.core.logger.ConsoleLogger
import com.vibh.hiltlearninglab.core.logger.Logger
import com.vibh.hiltlearninglab.core.qualifier.ConsoleLoggerQualifier
import com.vibh.hiltlearninglab.core.qualifier.FileLoggerQualifier
import javax.inject.Inject

class GreetingService @Inject constructor(
    @ConsoleLoggerQualifier
    //@FileLoggerQualifier
    private val logger: Logger
) {
    //fun message() : String = "Hello from Hilt!"
    fun message(): String {
        logger.log("Generating greeting")
        return "Hello from Hilt!"
    }
}
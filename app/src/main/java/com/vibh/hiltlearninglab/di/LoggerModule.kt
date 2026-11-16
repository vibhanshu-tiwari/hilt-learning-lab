package com.vibh.hiltlearninglab.di

import com.vibh.hiltlearninglab.core.logger.ConsoleLogger
import com.vibh.hiltlearninglab.core.logger.FileLogger
import com.vibh.hiltlearninglab.core.logger.Logger
import com.vibh.hiltlearninglab.core.qualifier.ConsoleLoggerQualifier
import com.vibh.hiltlearninglab.core.qualifier.FileLoggerQualifier
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LoggerModule {
    @Binds
    @ConsoleLoggerQualifier
    abstract fun bindConsoleLogger(
        consoleLogger: ConsoleLogger
    ): Logger

    @Binds
    @FileLoggerQualifier
    abstract fun bindFileLogger(
        fileLogger: FileLogger
    ): Logger
}
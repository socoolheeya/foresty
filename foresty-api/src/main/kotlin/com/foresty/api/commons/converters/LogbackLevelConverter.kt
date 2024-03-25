package com.foresty.api.commons.converters

import ch.qos.logback.classic.Level
import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.pattern.color.ANSIConstants
import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase

class LogbackLevelConverter: ForegroundCompositeConverterBase<ILoggingEvent>() {
    override fun getForegroundColorCode(event: ILoggingEvent): String {
        return when (event.level.levelInt) {
            Level.ERROR.toInt() -> ANSIConstants.RED_FG
            Level.WARN.toInt() -> ANSIConstants.YELLOW_FG
            Level.INFO.toInt() -> ANSIConstants.BLUE_FG
            Level.DEBUG.toInt() -> ANSIConstants.GREEN_FG
            else -> ANSIConstants.DEFAULT_FG
        }
    }
}
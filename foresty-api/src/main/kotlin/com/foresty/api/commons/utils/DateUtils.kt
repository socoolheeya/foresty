package com.foresty.api.commons.utils

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class DateUtils {
    companion object {
        fun kotlinNow(timeZone: TimeZone = TimeZone.UTC): LocalDateTime {
            return Clock.System.now().toLocalDateTime(timeZone)
        }

        fun javaNow(): java.time.LocalDateTime {
            return java.time.LocalDateTime.now()
        }
    }
}
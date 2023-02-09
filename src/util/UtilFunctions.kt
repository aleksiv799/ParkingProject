package util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class UtilFunctions {

fun initTimer(): String {
    return LocalDateTime.now()
        .format(DateTimeFormatter.ofPattern("hh:mm:ss a"))

    }
}
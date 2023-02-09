package util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.roundToLong


object UtilFunctions {

fun initTimer(): String {
    return LocalDateTime.now()
        .format(DateTimeFormatter.ofPattern("hh:mm:ss a"))

    }

    fun String.toColor(color: String): String {
        return  "${color}$this${Colors.resetColor}"
    }

    fun timerChecked(timeParking: Long): Long {
        return ((System.nanoTime().toDouble() - timeParking) / 1000000000).roundToLong()
    }
}
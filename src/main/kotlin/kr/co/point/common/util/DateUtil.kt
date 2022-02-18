package kr.co.point.common.util

import org.springframework.format.Formatter
import java.time.*
import java.time.format.DateTimeFormatter
import java.util.*

class Date : Formatter<OffsetDateTime> {

    override fun parse(text: String, locale: Locale): OffsetDateTime {
        val millis = text.toLong()
        return OffsetDateTime.ofInstant(Instant.ofEpochMilli(millis), ZoneId.of("Asia/Seoul"))
    }

    override fun print(offsetDateTime: OffsetDateTime, locale: Locale): String {
        return "${offsetDateTime.toInstant().toEpochMilli()}"
    }
}

fun getLocalDateTime(yyyyMMdd: String, HHmm: String): LocalDateTime {
    val str = "$yyyyMMdd $HHmm"
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    return LocalDateTime.parse(str, formatter)
}

fun getCurrentDateTimeConnect(): String {
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
    return current.format(formatter)
}
fun getLocalDateToString(localDateTime: LocalDateTime): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    return localDateTime.format(formatter)
}

fun getLocalDateTimeToString(localDateTime: LocalDateTime): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd h:m a")
    return localDateTime.format(formatter)
}

fun stringToLocalDateTime(localDateTime: String) : LocalDateTime{
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
    return LocalDateTime.parse(localDateTime, formatter)
}

fun getLocalDateTimeToVbank(localDateTime: LocalDateTime): String {
    val resFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 까지")
    return localDateTime.format(resFormatter)
}


fun getDate(localDateTime: LocalDateTime): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
    return localDateTime.format(formatter)
}

fun getDateYYmmdd(localDateTime: LocalDateTime): String {
    val formatter = DateTimeFormatter.ofPattern("yy. MM. dd")
    return localDateTime.format(formatter)
}

fun getDateTimeBackslash(localDateTime: LocalDateTime): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy / MM / dd / HH:mm")
    return localDateTime.format(formatter)
}

fun getDateBackslash(localDateTime: LocalDateTime): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy / MM / dd")
    return localDateTime.format(formatter)
}
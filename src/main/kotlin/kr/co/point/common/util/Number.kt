package kr.co.point.common.util

import java.text.DecimalFormat

fun dotNumberStrNormal(integer: Int): String {
    return DecimalFormat("###,###").format(integer)
}

fun dotNumberStrNormal(double: Double): String {
    return DecimalFormat("###,###").format(double)
}

fun dotNumberStr(integer: Int): String {
    val decimalFormat: DecimalFormat = if (integer < 1) {
        DecimalFormat("###,###")
    } else {
        DecimalFormat("+###,###")
    }

    return decimalFormat.format(integer)
}

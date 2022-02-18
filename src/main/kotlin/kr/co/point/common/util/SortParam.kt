package kr.co.point.common.util

import org.springframework.data.domain.Sort

fun sortParamString(sort: Sort): String {
    var sortStr = ""

    sort.stream().forEach {
            s: Sort.Order -> sortStr += "&sort="
                             sortStr += s.property + ","
                             sortStr += s.direction
    }

    return sortStr
}
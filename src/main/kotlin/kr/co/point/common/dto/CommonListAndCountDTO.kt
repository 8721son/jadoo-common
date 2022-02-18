package kr.co.point.common.dto

data class CommonListAndCountDTO<T> (
    var list: List<T>? = null,
    var totalCount: Long = 0
)
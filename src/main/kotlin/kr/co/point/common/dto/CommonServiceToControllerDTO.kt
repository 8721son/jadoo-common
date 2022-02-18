package kr.co.point.common.dto

data class CommonServiceToControllerDTO<T> (
    var code: Int = 0,
    var message: String = "",
    var content: T?
)
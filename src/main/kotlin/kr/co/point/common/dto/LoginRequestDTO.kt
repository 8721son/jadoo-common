package kr.co.point.common.dto

data class LoginRequestDTO(
    var grant_type: String = "",
    var scope: String = "",
    var username: String =  "",
    var password: String = ""
)
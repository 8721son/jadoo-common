package kr.co.point.common.dto.member.request


data class SignInEmailRequestDTO(
    var email: String = "",
    var password: String = "",
)

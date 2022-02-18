package kr.co.point.common.dto.member.request


data class SignInOauthRequestDTO(
    var provider: String = "",
    var token: String = "",
)

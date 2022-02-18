package kr.co.point.common.dto.member.request


data class ResetPwRequestDTO(

    var email: String = "",
    var iamportUid: String = "",

    var password: String = "",
    var passwordConfirm: String = "",
)

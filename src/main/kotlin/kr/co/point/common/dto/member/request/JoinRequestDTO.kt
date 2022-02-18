package kr.co.point.common.dto.member.request

import kr.co.point.common.dto.file.response.FileDTO

data class JoinRequestDTO(
    var provider: String = "",
    var nickname: String = "",
    var name: String = "",
    var email: String = "",
    var emailConfirmCode: String = "",
    var phone: String = "",
    var iamportUid: String = "",
    var password: String = "",
    var passwordConfirm: String = "",
    var profile: FileDTO? = null,
    var oauthToken: String = "",
    var tags: List<Int>? = null,
)

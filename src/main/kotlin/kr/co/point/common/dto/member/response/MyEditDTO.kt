package kr.co.point.common.dto.member.response

import kr.co.point.common.dto.file.response.FileDTO

data class MyEditDTO(
    var idx: Int = 0,
    var nickname: String = "",
    var name: String = "",
    var birth: String = "",
    var email: String = "",
    var phone: String = "",
    var profileImg: FileDTO? = null,
    var googleAuthDate: String = "",
    var appleAuthDate: String = "",
    var kakaoAuthDate: String = "",
    var brix: Int = 0,
    var appleAuthYn: Boolean = false,
    var googleAuthYn: Boolean = false,
    var kakaoAuthYn: Boolean = false,
)

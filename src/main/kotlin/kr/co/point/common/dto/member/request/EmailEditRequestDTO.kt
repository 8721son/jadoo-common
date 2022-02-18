package kr.co.point.common.dto.member.request

data class EmailEditRequestDTO(
    var email: String = "",
    var code: Int = 1,
)

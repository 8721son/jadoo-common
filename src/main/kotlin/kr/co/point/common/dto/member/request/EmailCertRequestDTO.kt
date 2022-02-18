package kr.co.point.common.dto.member.request

data class EmailCertRequestDTO(
    var email: String = "",
    var code: Int = 0,
)

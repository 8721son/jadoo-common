package kr.co.point.common.dto.member.request

data class NotificationRequestDTO(
    var arlim: Boolean = false,
    var marketing: Boolean = false,
    var night: Boolean = false,
)

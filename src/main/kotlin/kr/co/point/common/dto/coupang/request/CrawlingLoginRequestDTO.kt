package kr.co.point.common.dto.coupang.request

import java.time.LocalDate

data class CrawlingLoginRequestDTO(
    var coupangEmail: String = "",
    var coupangPw: String = "",
    var captchaAnswer: String? = null, // 캡차 Answer
    var token: String? = null, // 캡차 토큰
    var fcmToken: String = "", // FCM 토큰
    var ssaid: String = "",
    var finishDate: LocalDate = LocalDate.now()
 )

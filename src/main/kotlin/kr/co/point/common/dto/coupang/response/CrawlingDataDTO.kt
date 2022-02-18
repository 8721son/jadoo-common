package kr.co.point.common.dto.coupang.response

data class CrawlingDataDTO<COUPANGDATA>(

    var success: Boolean = false,
    var resultTypeCode: String = "",
    var message: String = "", // 캡차 Answer
    var data: COUPANGDATA? = null, // 캡차 Answer

    var cookieMap: Map<String, String> = HashMap(),
 )
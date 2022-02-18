package kr.co.point.common.dto.coupang.request

data class CrawlingAuthRequestDTO(
    var pincode: String = "",
    var cookieMap: Map<String, String> = HashMap(),
 )

package kr.co.point.common.dto.coupang.response

data class CoupangSearchProductDTO(
    var landingUrl: String = "",
    var productData: List<CoupangProductDTO> = ArrayList(),
 )

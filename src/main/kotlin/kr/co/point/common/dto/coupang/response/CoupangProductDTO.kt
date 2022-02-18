package kr.co.point.common.dto.coupang.response

data class CoupangProductDTO(
    var idx: Long = 0,
    var title: String = "",
    var photo: String = "",
    var price: Int = 0,
    var url: String = "",
    var isRocket: Boolean = false,
    var isFreeShipping: Boolean = false,
 )

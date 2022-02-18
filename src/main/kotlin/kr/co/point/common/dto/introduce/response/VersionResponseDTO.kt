package kr.co.point.common.dto.introduce.response

data class VersionResponseDTO(
    var min : Int = 0,
    var current : Int = 0,
    var marketUrl : String = "",
    var iamportCode : String = "",
    var isPatch: Boolean = false,
    var patchDate: String = "",
    var bootpay: Boolean = false,
    var coupang: Boolean = false,
)


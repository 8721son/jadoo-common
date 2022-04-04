package kr.co.point.common.dto.member.request

import kr.co.point.common.entity.member.MemberDeliveryAddress

data class DeliveryAddressRequestDTO(
    var name : String? = "",
    var username : String = "",
    var hp : String = "",
    var tel : String? = "",
    var zipCode : String = "",
    var address : String = "",
    var detailAddress : String = "",
    var defaultYn : String = "N"
)

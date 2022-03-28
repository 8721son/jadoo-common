package kr.co.point.common.dto.partners.response

import kr.co.point.common.dto.file.response.FileDTO

data class PartnersPurchaseProductListDTO(
    var idx : Int = 0,
    var orderNumber : String = "",
    var thumbnail : FileDTO = FileDTO(),
    var name : String = "",
    var purchaseDate : String = "",
)

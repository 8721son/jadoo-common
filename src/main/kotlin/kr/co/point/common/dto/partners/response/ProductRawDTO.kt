package kr.co.point.common.dto.partners.response

import kr.co.point.common.dto.file.response.FileDTO

data class ProductRawDTO(
    var quantity: Int = 0,
    var origin_price : Int = 0,
    var price : Double = 0.0,
    var discount_price : Int =0,
    var total_price : Double = 0.0,
)

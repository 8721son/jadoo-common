package kr.co.point.common.dto.partners.response

import kr.co.point.common.dto.file.response.FileDTO

data class ProductDTO(
    var idx : Int = 0,
    var thumbnail : FileDTO = FileDTO(),
    var partners : String = "",
    var name : String = "",
    var option : String = "",
    var quantity: String = "",
    var originPrice : String = "",
    var price : String = "",
    var totalPrice : String = "",
    var status : String = "",

    var review : Boolean = false,
    var change : Boolean = false,
    var confirm : Boolean = false,
    var cancel : Boolean = false,


    var refund_method : String? = null,
    var refund_price : String? = null,

    var change_reason : String? = null,
    var delivery_price : String? = null,
)

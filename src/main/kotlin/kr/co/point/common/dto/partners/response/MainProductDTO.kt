package kr.co.point.common.dto.partners.response

import kr.co.point.common.dto.file.response.FileDTO

data class MainProductDTO(
    var idx : Int = 0,
    var thumbnail : FileDTO = FileDTO(),
    var name : String = "",
    var discountRate : Int = 0,
    var price : String = "",
    var isLike : Boolean = false,
)

package kr.co.point.common.dto.partners.response

import kr.co.point.common.dto.file.response.FileDTO
import kr.co.point.common.dto.member.response.MyDTO

data class PartnersReviewListDTO(
   var idx: Int = 0,
   var member_idx : Int? = 0,
   var member : MyDTO? = MyDTO(),
   var productImg : FileDTO? = FileDTO(),
   var review : String = "",
   var deleteYn : String = "N",
   var purchase_product_idx : Int = 0,
   var createDate : String = "",
   var option : String? = "",

)

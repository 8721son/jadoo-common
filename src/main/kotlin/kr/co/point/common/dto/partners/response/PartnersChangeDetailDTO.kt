package kr.co.point.common.dto.partners.response

import kr.co.point.common.dto.file.response.FileDTO
import kr.co.point.common.dto.member.response.MemberDeliveryAddressDTO

data class PartnersChangeDetailDTO(
   var orderNumber : String = "",
   var products : List<ProductDTO> = ArrayList(),
   var address : MemberDeliveryAddressDTO = MemberDeliveryAddressDTO(),
   var payment_method : String = "",
   var quantity : String = "",
   var origin_price : String = "",
   var ship_price : String = "",
   var discount_price : String = "",
   var price : String = "",
)

package kr.co.point.common.dto.partners.response

import kr.co.point.common.dto.file.response.FileDTO
import kr.co.point.common.dto.member.response.MemberDeliveryAddressDTO

data class PartnersSearchCategoryDTO(
   var code : Int = 0,
   var name : String = "",
   var detail : PartnersSearchCategoryDetailDTO? = null,

)

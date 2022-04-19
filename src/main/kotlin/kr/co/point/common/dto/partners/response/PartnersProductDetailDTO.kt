package kr.co.point.common.dto.partners.response

import kr.co.point.common.dto.file.response.FileDTO
import kr.co.point.common.dto.member.response.MemberDeliveryAddressDTO
import kr.co.point.common.entity.file.File
import kr.co.point.common.entity.partners.Partners
import kr.co.point.common.entity.partners.PartnersProductOption
import kr.co.point.common.entity.partners.PartnersProductSaleOption
import kr.co.point.common.enum_package.status.MemberStatus
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

data class PartnersProductDetailDTO(
   var idx: Int? = null,
   var partners : PartnersDTO = PartnersDTO(),
   var name : String = "",
   var thumbnail : FileDTO = FileDTO(),

   var originPrice : String = "",
   var price : String = "",
   var discountRate : Int = 0,

   var detailImg : FileDTO? = FileDTO(),

   var isLike : Boolean = false,
   var soldoutYn : String = "N",

   var reviewCnt : Int = 0,
   var review : List<PartnersReviewListDTO>? = ArrayList(),

   var info : List<PartnersProductInfoDTO>? = ArrayList(),

   var option: List<PartnersProductOptionDTO>? = ArrayList(),
)

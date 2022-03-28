package kr.co.point.common.dto.partners.response

import kr.co.point.common.dto.file.response.FileDTO
import kr.co.point.common.dto.member.MemberDTO
import kr.co.point.common.dto.member.response.MemberDeliveryAddressDTO
import kr.co.point.common.dto.member.response.MyDTO
import kr.co.point.common.entity.file.File
import kr.co.point.common.entity.member.Member
import kr.co.point.common.entity.partners.PartnersPurchaseProductList
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

data class PartnersReviewDTO(
   var idx: Int? = null,
   var product : ProductDTO = ProductDTO(),
   var member_idx : Int? = null,
   var member : MyDTO? = MyDTO(),
   var productImg : FileDTO? = FileDTO(),
   var review : String = "",
   var deleteYn : String = "N",
   var purchase_product_idx : Int =0,
   var createDate : String = "",
   var option : String? = "",
)

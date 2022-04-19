package kr.co.point.common.dto.partners.response

import kr.co.point.common.dto.file.response.FileDTO
import kr.co.point.common.dto.member.response.MemberDeliveryAddressDTO
import kr.co.point.common.entity.file.File
import kr.co.point.common.entity.partners.Partners
import kr.co.point.common.entity.partners.PartnersProduct
import kr.co.point.common.entity.partners.PartnersProductOption
import kr.co.point.common.entity.partners.PartnersProductSaleOption
import kr.co.point.common.enum_package.status.MemberStatus
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

data class PartnersProductInfoDTO(
   var idx: Int? = null,

   var name : String = "",
   var value : String = "",

   var showYn : String = "N",
)

package kr.co.point.common.dto.partners.response

import kr.co.point.common.dto.file.response.FileDTO
import kr.co.point.common.dto.member.response.MemberDeliveryAddressDTO
import kr.co.point.common.entity.file.File
import kr.co.point.common.entity.partners.Partners
import kr.co.point.common.enum_package.status.MemberStatus
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

data class PartnersProductDTO(
   var idx: Int? = null,
   var partners : Partners = Partners(),
   var name : String = "",
   var thumbnail : FileDTO = FileDTO(),
   var maxChangeDay : Int = 0,
   var showYn : String = "N",
   var price : Int = 0,
   var discountRate : Int = 0,
)

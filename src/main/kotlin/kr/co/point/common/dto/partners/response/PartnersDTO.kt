package kr.co.point.common.dto.partners.response

import kr.co.point.common.dto.file.response.FileDTO
import kr.co.point.common.dto.member.response.MemberDeliveryAddressDTO
import kr.co.point.common.entity.file.File
import kr.co.point.common.enum_package.status.MemberStatus
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

data class PartnersDTO(
   var idx: Int? = null,
   var hp : String = "",
   var business_name : String = "",
   var companyRegistrationNumber : Int = 0,
   var logoImg : FileDTO = FileDTO(),
   var mainImg : FileDTO? = null,
   var description : String? = null,
   var status : MemberStatus = MemberStatus.NORMAL,
)
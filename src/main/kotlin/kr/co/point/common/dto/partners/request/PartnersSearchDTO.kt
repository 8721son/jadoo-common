package kr.co.point.common.dto.partners.request

import kr.co.point.common.dto.file.response.FileDTO
import kr.co.point.common.entity.file.File
import kr.co.point.common.entity.member.Member
import kr.co.point.common.entity.partners.PartnersProduct
import kr.co.point.common.enum_package.type.PartnersSearchType
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

data class PartnersSearchDTO(
    var type : PartnersSearchType = PartnersSearchType.PRODUCT,
    var keyword : String = "",
)

package kr.co.point.common.dto.member.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kr.co.point.common.entity.member.Member
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

data class MemberDeliveryAddressDTO(
    var idx : Int = 0,
    var defaultYn: String = "N",
    var name : String = "",
    var username : String = "",
    var hp : String = "",
    var tel : String? = null,
    var address : String = "",
    var address_detail : String = "",
    var zip_code : String = "",
)

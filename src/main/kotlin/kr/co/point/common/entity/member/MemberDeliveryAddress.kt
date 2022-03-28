package kr.co.point.common.entity.member

import kr.co.point.common.dto.member.response.MemberDeliveryAddressDTO
import kr.co.point.common.dto.search.response.TagDTO
import kr.co.point.common.dto.search.response.TagKeywordDTO
import kr.co.point.common.entity.search.TagCode
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class MemberDeliveryAddress(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @ManyToOne(targetEntity = Member::class)
    @JoinColumn(name = "member_idx", referencedColumnName = "idx")
    var member: Member = Member(),

    var defaultYn: String = "N",
    var name : String = "",
    var username : String = "",
    var hp : String = "",
    var tel : String? = null,
    var address : String = "",
    var address_detail : String = "",
    var zip_code : String = "",

    @CreationTimestamp
    var createDate: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updateDate: LocalDateTime? = null,
){
    fun toDTO() : MemberDeliveryAddressDTO{
        return MemberDeliveryAddressDTO(
            idx!!, defaultYn, name, username, hp, tel, address, address_detail, zip_code
        )
    }
}
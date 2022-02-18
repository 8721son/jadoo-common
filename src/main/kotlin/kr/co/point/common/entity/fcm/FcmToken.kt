package kr.co.point.common.entity.fcm

import kr.co.point.common.dto.fcm.response.FcmAgreeResponseDTO
import kr.co.point.common.entity.member.Member
import kr.co.point.common.enum_package.type.OSType
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class FcmToken(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, insertable = false)
        var idx: Int? = null,

        @ManyToOne(targetEntity = Member::class)
        @JoinColumn(name = "member_idx", referencedColumnName = "idx")
        var member: Member? = null,

        var token: String = "",
        var ssaid: String = "",

        @Enumerated(EnumType.STRING)
        var osType: OSType = OSType.A,

        var arlimAgreeYn: String = "N",
        var marketingAgreeYn: String = "N",
        var nightAgreeYn: String = "N",

        var arlimAgreeDate: LocalDateTime? = null,
        var marketingAgreeDate: LocalDateTime? = null,
        var nightAgreeDate: LocalDateTime? = null,

        @CreationTimestamp
        var createDate: LocalDateTime? = null,

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
) {

        fun toAgreeDTO(): FcmAgreeResponseDTO {
                return FcmAgreeResponseDTO(
                        arlimAgreeYn == "Y",
                        marketingAgreeYn == "Y",
                        nightAgreeYn == "Y"
                )
        }

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as FcmToken

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , member = $member , token = $token , ssaid = $ssaid , osType = $osType , arlimAgreeYn = $arlimAgreeYn , marketingAgreeYn = $marketingAgreeYn , nightAgreeYn = $nightAgreeYn , arlimAgreeDate = $arlimAgreeDate , marketingAgreeDate = $marketingAgreeDate , nightAgreeDate = $nightAgreeDate , createDate = $createDate , updateDate = $updateDate )"
        }



}
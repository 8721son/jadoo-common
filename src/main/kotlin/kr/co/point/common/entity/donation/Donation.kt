package kr.co.point.common.entity.donation

import kr.co.point.common.dto.donation.v1.response.DonationReponseDTO
import kr.co.point.common.entity.member.Member
import kr.co.point.common.entity.point.Point
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Donation(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var idx: Int? = null,

        @ManyToOne(targetEntity = Campaign::class)
        @JoinColumn(name = "campaign_idx", referencedColumnName = "idx")
        var campaign: Campaign = Campaign(),

        @ManyToOne(targetEntity = Member::class)
        @JoinColumn(name = "member_idx", referencedColumnName = "idx")
        var member: Member = Member(),

        var brix: Int = 0,

        @OneToOne(targetEntity = Point::class)
        @JoinColumn(name = "point_idx", referencedColumnName = "idx")
        var point: Point? = null,

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),
) {

        fun toDTO(): DonationReponseDTO {
                return DonationReponseDTO(campaign.idx!!, campaign.brix, campaign.currentBrix)
        }

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as Donation

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , campaign = $campaign , member = $member , brix = $brix , point = $point , createDate = $createDate )"
        }
}

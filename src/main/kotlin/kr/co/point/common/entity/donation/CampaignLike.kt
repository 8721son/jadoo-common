package kr.co.point.common.entity.donation

import kr.co.point.common.dto.donation.v1.response.CampaignDTO
import kr.co.point.common.entity.member.Member
import kr.co.point.common.util.getLocalDateToString
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*


@Entity
data class CampaignLike(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var idx: Int? = null,

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member::class)
        @JoinColumn(name = "member_idx", referencedColumnName = "idx")
        var member: Member = Member(),

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Campaign::class)
        @JoinColumn(name = "campaign_idx", referencedColumnName = "idx")
        var campaign: Campaign = Campaign(),

    @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
) {

        fun toCampaignDTO() : CampaignDTO {
                return CampaignDTO(
                        campaign.idx!!,
                        campaign.photo.toDTO(),
                        campaign.title,
                        campaign.company.name,
                        true,
                        getLocalDateToString(campaign.endDate!!),
                        campaign.brix,
                        campaign.currentBrix,
                        campaign.campaignTags.map { campaignTag -> campaignTag.tag.toTagDTO() }
                )
        }


        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as CampaignLike

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , member = $member , campaign = $campaign , createDate = $createDate , updateDate = $updateDate )"
        }
}


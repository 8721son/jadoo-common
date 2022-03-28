package kr.co.point.common.entity.donation

import kr.co.point.common.dto.donation.v1.response.CampaignExecutionDTO
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class CampaignExecution(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var idx: Int? = null,

        @ManyToOne(fetch = FetchType.EAGER, targetEntity = Campaign::class)
        @JoinColumn(name = "campaign_idx", referencedColumnName = "idx")
        var campaign: Campaign = Campaign(),

        var category: String = "",
        var title: String = "",
        var content: String = "",

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
){
        fun toDTO() : CampaignExecutionDTO{
                return CampaignExecutionDTO(
                        title,content
                )
        }
}
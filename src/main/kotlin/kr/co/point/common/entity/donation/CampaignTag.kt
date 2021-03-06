package kr.co.point.common.entity.donation

import kr.co.point.common.entity.search.TagCode
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class CampaignTag(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var idx: Int? = null,

        @ManyToOne(targetEntity = TagCode::class)
        @JoinColumn(name = "tag_idx", referencedColumnName = "idx")
        var tag: TagCode = TagCode(),

        @ManyToOne(targetEntity = Campaign::class)
        @JoinColumn(name = "campaign_idx", referencedColumnName = "idx")
        var campaign: Campaign = Campaign(),

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
) {

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as CampaignTag

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , tag = $tag , campaign = $campaign , createDate = $createDate , updateDate = $updateDate )"
        }
}


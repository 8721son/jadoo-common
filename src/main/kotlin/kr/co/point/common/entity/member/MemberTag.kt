package kr.co.point.common.entity.member

import kr.co.point.common.dto.search.response.TagDTO
import kr.co.point.common.dto.search.response.TagKeywordDTO
import kr.co.point.common.entity.search.TagCode
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class MemberTag(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var idx: Int? = null,

    @ManyToOne(targetEntity = Member::class)
        @JoinColumn(name = "member_idx", referencedColumnName = "idx")
        var member: Member = Member(),

    @ManyToOne(targetEntity = TagCode::class)
        @JoinColumn(name = "tag_idx", referencedColumnName = "idx")
        var tag: TagCode = TagCode(),

    @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
) {

        fun toTagDTO(): TagDTO {
                return TagDTO(tag.idx!!, tag.name)
        }

        fun toKeywordDTO() : TagKeywordDTO {
                return TagKeywordDTO(tag.idx!!, tag.name)
        }

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as MemberTag

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , member = $member , tag = $tag , createDate = $createDate , updateDate = $updateDate )"
        }
}

package kr.co.point.common.entity.talent

import kr.co.point.common.entity.search.TagCode
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class TalentTag(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, insertable = false)
        var idx: Int? = null,

        @ManyToOne(targetEntity = Talent::class)
        @JoinColumn(name = "talent_idx", referencedColumnName = "idx")
        var talent: Talent? = null,

        @ManyToOne(targetEntity = TagCode::class)
        @JoinColumn(name = "tag_idx", referencedColumnName = "idx")
        var tag: TagCode = TagCode(),

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
) {

        fun changeTalent(talent: Talent) {
                if (this.talent != null) {
                        this.talent = null
                }

                this.talent = talent
                talent.tag!!.add(this)
        }

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as TalentTag

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , talent = $talent , tag = $tag , createDate = $createDate , updateDate = $updateDate )"
        }

}
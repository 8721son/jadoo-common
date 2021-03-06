package kr.co.point.common.entity.talent

import kr.co.point.common.dto.talent.response.TalentCommentDTO
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class TalentComment(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, insertable = false)
        var idx: Int? = null,

        var comment: String = "",

        @ManyToOne(targetEntity = Talent::class)
        @JoinColumn(name = "talent_idx", referencedColumnName = "idx")
        var talent: Talent? = null,

        @OneToMany(fetch = FetchType.EAGER, mappedBy = "comment", cascade = [CascadeType.ALL], orphanRemoval = true)
        var reply: MutableList<TalentReply>? = null,

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
){
        fun toDTO() : TalentCommentDTO {
                return TalentCommentDTO(
                        idx,comment, talent, reply!!, createDate
                )
        }
        fun changeTalent(talent: Talent) {
                if (this.talent != null) {
                        this.talent = null
                }

                this.talent = talent
                talent.comments!!.add(this)
        }

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as TalentComment

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , comment = $comment , talent = $talent , createDate = $createDate , updateDate = $updateDate )"
        }
}
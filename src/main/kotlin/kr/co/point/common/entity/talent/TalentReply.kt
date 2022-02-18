package kr.co.point.common.entity.talent

import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class TalentReply(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, insertable = false)
        var idx: Int? = null,

        @ManyToOne(targetEntity = TalentComment::class)
        @JoinColumn(name = "talent_comment_idx", referencedColumnName = "idx")
        var comment: TalentComment? = null,

        var reply: String = "",

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
){
        fun changeComment(comment: TalentComment) {
                if (this.comment != null) {
                        this.comment = null
                }

                this.comment = comment
                comment.reply!!.add(this)
        }

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as TalentReply

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , comment = $comment , reply = $reply , createDate = $createDate , updateDate = $updateDate )"
        }

}
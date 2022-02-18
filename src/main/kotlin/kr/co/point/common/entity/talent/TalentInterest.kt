package kr.co.point.common.entity.talent

import kr.co.point.common.entity.member.Member
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class TalentInterest(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, insertable = false)
        var idx: Int? = null,

        @ManyToOne(targetEntity = Talent::class)
        @JoinColumn(name = "talent_idx", referencedColumnName = "idx")
        var talent: Talent = Talent(),

        @ManyToOne(targetEntity = Member::class)
        @JoinColumn(name = "member_idx", referencedColumnName = "idx")
        var member: Member = Member(),

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
) {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as TalentInterest

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , talent = $talent , member = $member , createDate = $createDate , updateDate = $updateDate )"
        }

}
package kr.co.point.common.entity.talent

import kr.co.point.common.entity.member.Member
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class TalentAttendance(
        //프로젝트 요청 테이블
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, insertable = false)
        var idx: Int? = null,

        @ManyToOne(targetEntity = Talent::class)
        @JoinColumn(name = "talent_idx", referencedColumnName = "idx")
        var talent: Talent? = null,

        @ManyToOne(targetEntity = Member::class)
        @JoinColumn(name = "member_idx", referencedColumnName = "idx")
        var member: Member = Member(),

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
                talent.participant!!.add(this)
        }

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as TalentAttendance

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , talent = $talent , member = $member , createDate = $createDate , updateDate = $updateDate )"
        }

}
package kr.co.point.common.entity.talent

import kr.co.point.common.entity.member.Member
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class TalentGift(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, insertable = false)
        var idx: Int? = null,

        @ManyToOne(targetEntity = Talent::class)
        @JoinColumn(name = "talent_idx", referencedColumnName = "idx")
        var talent: Talent = Talent(),

        @ManyToOne(targetEntity = Member::class)
        @JoinColumn(name = "sender_idx",referencedColumnName = "idx")
        var sender: Member = Member(),

        @ManyToOne(targetEntity = Member::class)
        @JoinColumn(name = "receiver_idx",referencedColumnName = "idx")
        var receiver: Member = Member(),

        var brix: Int = 0,

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
)
package kr.co.point.common.entity.main

import kr.co.point.common.entity.member.Member
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class MagazineLike(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @OneToOne(targetEntity = Magazine::class)
    @JoinColumn(name = "magazine_idx", referencedColumnName = "idx")
    var magazine: Magazine = Magazine(),

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member::class)
    @JoinColumn(name = "member_idx", referencedColumnName = "idx")
    var member: Member = Member(),

    @CreationTimestamp
    var createDate: LocalDateTime? = null,

)
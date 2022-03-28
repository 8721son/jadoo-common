package kr.co.point.common.entity.pedometer

import kr.co.point.common.entity.member.Member
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class AdmobFailLog(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    var os : String = "",

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member::class)
    @JoinColumn(name = "member_idx", referencedColumnName = "idx")
    var member: Member? = null,

    var code : Int = 0,
    var domain : String = "",
    var message : String = "",

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updateDate : LocalDateTime? = null,
)
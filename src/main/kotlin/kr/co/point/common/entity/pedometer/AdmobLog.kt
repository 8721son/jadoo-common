package kr.co.point.common.entity.pedometer

import kr.co.point.common.entity.member.Member
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class AdmobLog(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    var adNetwork : String = "",
    var adUnit : String ="",
    var rewardAmount : String ="",
    var rewardItem : String = "",

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member::class)
    @JoinColumn(name = "member_idx", referencedColumnName = "idx")
    var member: Member? = null,

    var customData : String? = "",
    var timestamp : String = "",
    var transactionId :String = "",
    var signature : String = "",
    var keyId : String = "",

    var exchangeYn : String = "N",

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updateDate : LocalDateTime? = null,
)
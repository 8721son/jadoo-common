package kr.co.point.common.entity.donation

import kr.co.point.common.entity.member.Member
import kr.co.point.common.enum_package.type.DonationReceiptType
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class DonationReceipt(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var idx: Int? = null,

        @ManyToOne(targetEntity = Member::class)
        @JoinColumn(name = "member_idx", referencedColumnName = "idx")
        var member: Member = Member(),

        @Enumerated(EnumType.STRING)
        var type : DonationReceiptType = DonationReceiptType.PERSONAL,

        var name : String = "",
        var identificationNumber : String? = null,
        var businessNumber : String? = null,

        var address: String = "",
        var detailAddress: String = "",

        var brix: Int = 0,

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),
)
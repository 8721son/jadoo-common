package kr.co.point.common.entity.bootpay

import kr.co.point.common.dto.bootpay.request.PaymentDataDTO
import kr.co.point.common.entity.member.Member
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class BootpayFailLog(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var idx: Int? = null,

        @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member::class)
        @JoinColumn(name = "member_idx", referencedColumnName = "idx")
        var member: Member = Member(),
        var orderId: String? = null,
        var methodName: String? = null,
        var step: String = "",
        var reason: String = "",

        @CreationTimestamp
        var createDate: LocalDateTime? = null
)

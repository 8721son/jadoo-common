package kr.co.point.common.entity.bootpay

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kr.co.point.common.dto.bootpay.response.VbankDTO
import kr.co.point.common.entity.member.Member
import kr.co.point.common.enum_package.type.BootpayType
import kr.co.point.common.util.dotNumberStrNormal
import kr.co.point.common.util.getLocalDateTimeToVbank
import kr.co.point.common.util.stringToLocalDateTime
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class BootpayLog(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var idx: Int? = null,

        @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member::class)
        @JoinColumn(name = "member_idx", referencedColumnName = "idx")
        var member: Member = Member(),

        var price: Int = 0,
        var receiptId: String = "",
        var orderId: String = "",
        @Enumerated(EnumType.STRING)
        var type : BootpayType = BootpayType.BRIX,
        var name: String = "",
        var unit: String = "",
        var pg: String = "",
        var method: String = "",
        var pgName: String = "",
        var methodName: String = "",
        @Column(length = 1000)
        var paymentData: String? = null,
        var receiptUrl: String = "",
        var requestAt: String = "",
        var purchasedAt: String? = null,
        var status: String? = null,
        @CreationTimestamp
        var createDate: LocalDateTime? = null
)
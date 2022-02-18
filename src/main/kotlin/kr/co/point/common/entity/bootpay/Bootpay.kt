package kr.co.point.common.entity.bootpay

import kr.co.point.common.entity.member.Member
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Bootpay(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var idx: Int? = null,

        @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member::class)
        @JoinColumn(name = "member_idx", referencedColumnName = "idx")
        var member: Member = Member(),

        var price: Int = 0,
        var receiptId: String = "",
        var orderId: String = "",
        var name: String = "",
        var unit: String = "",
        var pg: String = "",
        var method: String = "",
        var pgName: String = "",
        var methodName: String = "",

        @Column(length = 1000)
        var paymentData: String = "",
        var receiptUrl: String = "",
        var requestAt: String = "",
        var purchasedAt: String = "",
        var status: String? = null,
        @CreationTimestamp
        var createDate: LocalDateTime? = null,
        @UpdateTimestamp
        var updateDate: LocalDateTime? = null
)
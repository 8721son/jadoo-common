package kr.co.point.common.entity.bootpay

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import kr.co.point.common.dto.bootpay.response.VbankDTO
import kr.co.point.common.entity.member.Member
import kr.co.point.common.enum_package.type.BootpayType
import kr.co.point.common.util.dotNumberStrNormal
import kr.co.point.common.util.getLocalDateTimeToVbank
import kr.co.point.common.util.stringToLocalDateTime
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

        @Enumerated(EnumType.STRING)
        var type : BootpayType = BootpayType.BRIX,
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
        var updateDate: LocalDateTime? = null,

        var expiredDate: String? = ""
){
        fun toVbankDTO () : VbankDTO? {
                val mapper = jacksonObjectMapper()
                val data = mapper.readValue(paymentData, Map::class.java)
                val localDateTime = stringToLocalDateTime(data.get("expiredate") as String)

                if(localDateTime<LocalDateTime.now()){
                        return null;
                }
                return VbankDTO(
                        data.get("bankname") as String,
                        data.get("accountholder") as String,
                        getLocalDateTimeToVbank(localDateTime),
                        data.get("account") as String,
                        dotNumberStrNormal(price),
                )
        }
}

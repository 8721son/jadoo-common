package kr.co.point.common.entity.coupang.api

import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class CoupangApi(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,
    var date /*날짜, 형식: yyyyMMdd*/: String? = null,
    var trackingCode /*회원 AF 아이디*/: String? = null,
    var orderId /*주문 번호*/: Long? = null,
    var price: Int? = null,

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "coupang")
    var products: List<CoupangApiProduct>? = null,

    @CreationTimestamp
    var createDate: LocalDateTime? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as CoupangApi

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , date = $date , trackingCode = $trackingCode , orderId = $orderId , price = $price , createDate = $createDate )"
    }
}
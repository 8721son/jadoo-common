package kr.co.point.common.entity.coupang.api

import lombok.Builder
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

    @OneToMany(mappedBy = "coupang")
    @Builder.Default
    var products: MutableList<CoupangApiProduct> = ArrayList(),

    @CreationTimestamp
    var createDate: LocalDateTime? = null
)
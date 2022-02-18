package kr.co.point.common.entity.coupang.crawling

import kr.co.point.common.entity.member.Member
import lombok.Builder
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class CoupangCrawling(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,


    @ManyToOne(targetEntity = Member::class)
    @JoinColumn(name = "member_idx", referencedColumnName = "idx")
    var member: Member = Member(),

    @OneToMany(mappedBy = "crawling")
    @Builder.Default
    var productList: List<CoupangCrawlingProduct> = ArrayList(),

    var orderDateTime: LocalDateTime? = null,
    var orderId: Long? = null,
    var price  : Int? = null,
    var discountPrice: Int? = null,
    var deliveryPrice: Int? = null,
    var paymentPrice : Int? = null,

    @CreationTimestamp
    var createDate: LocalDateTime? = null,

    @UpdateTimestamp
    var updateDate: LocalDateTime? = null,
)

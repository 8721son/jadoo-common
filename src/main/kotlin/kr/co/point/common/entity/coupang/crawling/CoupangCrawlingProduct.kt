package kr.co.point.common.entity.coupang.crawling

import kr.co.point.common.enum_package.status.OrderStatus
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class CoupangCrawlingProduct(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,
    var productName: String? = null,
    var vendorItemName: String? = null,
    var productId: Long? = null,
    var originPrice: Int? = null,
    var price: Int? = null,
    var quantity: Int? = null,
    var cancelQuantity: Int? = null,

    @Enumerated(EnumType.STRING)
    var orderStatus : OrderStatus? = null,

    var cancelYn: String? = null,
    var matchYn: String? = null,
    var originData: String? = null,

    @ManyToOne
    @JoinColumn(name = "crawling_idx")
    var crawling: CoupangCrawling = CoupangCrawling(),

    @CreationTimestamp
    private val createDate: LocalDateTime? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as CoupangCrawlingProduct

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , productName = $productName , vendorItemName = $vendorItemName , productId = $productId , originPrice = $originPrice , price = $price , quantity = $quantity , cancelQuantity = $cancelQuantity , orderStatus = $orderStatus , cancelYn = $cancelYn , matchYn = $matchYn , originData = $originData , crawling = $crawling , createDate = $createDate )"
    }
}

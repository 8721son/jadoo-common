package kr.co.point.common.entity.coupang.api

import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class CoupangApiProduct(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @ManyToOne(targetEntity = CoupangApi::class)
    @JoinColumn(name = "coupang_idx", referencedColumnName = "idx")
    var coupang: CoupangApi? = null,

    var subId /*채널 아이디*/: String? = null,


    // 100: 여행 상품 페이지
    // 200: 상품 검색 페이지
    // 202: 여행 상품 검색 페이지
    // 300/302: 정기배송 페이지
    // 311: 카테고리 페이지
    // 312: 쿠팡 골드박스/캠페인 페이지
    // 313: 브랜드 페이지
    // 400: 상품 페이지
    // 411: 여행 상품 페이지
    // 500: 기획전 페이지
    // 600: 이벤트 페이지
    // 700: 로켓 배송/직구
    // 711: 로켓 와우
    // 900: 쿠팡 홈
    var addtag: String? = null,
    var ctag /*페이지 타입 상세*/: String? = null,
    var productId /*쿠팡 상품 ID*/: Long? = null,
    var productName /*상품 명*/: String? = null,
    var quantity /*구매 수량*/: Int? = null,
    var gmv /*구매 액*/: Int? = null,
    var commissionRate /*수수료 비율, 3.00%*/: Double? = null,
    var commission /*수수료*/: Int? = null,

    var matchYn: String? = null,
    var cancelYn: String? = null,

    @OneToOne(fetch = FetchType.EAGER, targetEntity = CoupangApiCancel::class)
    @JoinColumn(name = "cancel_idx", referencedColumnName = "idx")
    var coupangApiCancelEntity: CoupangApiCancel? = null,

    @CreationTimestamp
    private val createDate: LocalDateTime? = null,

    @UpdateTimestamp
    private val updateDate: LocalDateTime? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as CoupangApiProduct

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , coupang = $coupang , subId = $subId , addtag = $addtag , ctag = $ctag , productId = $productId , productName = $productName , quantity = $quantity , gmv = $gmv , commissionRate = $commissionRate , commission = $commission , matchYn = $matchYn , cancelYn = $cancelYn , coupangApiCancelEntity = $coupangApiCancelEntity , createDate = $createDate , updateDate = $updateDate )"
    }
}
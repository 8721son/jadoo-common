package kr.co.point.common.entity.coupang.api

import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class CoupangApiCancel(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    var orderDate /*날짜, 형식: yyyyMMdd*/: String? = null,
    var date /*날짜, 형식: yyyyMMdd*/: String? = null,

    var trackingCode: String? = null,
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

    @CreationTimestamp
    private val createDate: LocalDateTime? = null,

    )
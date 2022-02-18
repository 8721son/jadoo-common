package kr.co.point.common.enum_package.status

/**
 *     DELIVERED : 배송완료
 *     CANCELED : 취소완료
 *     REFUNDED : 환불완료(미구현)
 *     RETURNED : 반품완료
 *     EXCHANGED : 교환완료
 *     ETC : 기타
 **/
enum class OrderStatus {
    DELIVERED,
    CANCELED,
    REFUNDED,
    RETURNED,
    EXCHANGED,
    ETC
}
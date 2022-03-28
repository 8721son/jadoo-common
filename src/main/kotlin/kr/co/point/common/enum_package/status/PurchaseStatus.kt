package kr.co.point.common.enum_package.status

/**
(입금대기) payment_wait/
(결제 취소) payment_cancel/
(결제 완료) payment_done/
------------------------------------------
(상품 준비중) product_wait/
(배송 중) delivery/
(배송 완료) delivery_completion/
-> 언제든 가능
(구매확정) confirmation [포인트 리워드] 환불/교환 불가 -> 이 시점부터 리뷰 가능
 */
enum class PurchaseStatus(val purchaseStatus: String){
    PAYMENT_WAIT("입금 대기"),
    PAYMENT_CANCEL("결제 취소"),
    PAYMENT_DONE("결제 완료"),
    PRODUCT_WAIT("상품 준비중"),
    DELIVERY("배송중"),
    DELIVERY_COMPLETION("배송 완료"),
    CONFIRMATION("구매 확정"),
    REFUND("환불 완료"),
    EXCHANGE("교환 완료"),
    ALL("전체")
}



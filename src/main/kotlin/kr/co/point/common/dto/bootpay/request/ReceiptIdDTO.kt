package kr.co.point.common.dto.bootpay.request

data class ReceiptIdDTO(
    var receipt_id: String = "",
    var price : Int = 0,
    var method : String = "", //vbank, bank
)

package kr.co.point.common.dto.bootpay.request

data class ReceiptDTO(
    var status: Int = 0,
    var code: Int = 0,
    var message: String = "",
    var data: ReceiptDataDTO = ReceiptDataDTO()
)

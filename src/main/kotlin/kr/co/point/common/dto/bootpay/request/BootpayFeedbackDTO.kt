package kr.co.point.common.dto.bootpay.request

data class BootpayFeedbackDTO(
    var receipt_id: String = "",
    var pg: String = "",
    var pg_name: String = "",
    var method: String = "",
    var method_name: String = "",
    var application_id: String = "",
    var name: String = "",
    var private_key: String = "",
    var order_id: String = "",
    var receipt_url: String = "",
    var payment_data: PaymentDataDTO = PaymentDataDTO(),
    var price: Int = 0,
    var status: Int = 0
)

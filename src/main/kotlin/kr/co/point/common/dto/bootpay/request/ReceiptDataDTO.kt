package kr.co.point.common.dto.bootpay.request

data class ReceiptDataDTO(
    var receipt_id: String = "",
    var order_id: String = "",
    var name: String = "",
    var item_name: String = "",
    var price: Int = 0,
    var tax_free: Int = 0,
    var remain_price: Int = 0,
    var remain_tax_free: Int = 0,
    var cancelled_price: Int = 0,
    var cancelled_tax_free: Int = 0,
    var receipt_url: String = "",
    var unit: String = "",
    var pg: String = "",
    var method: String = "",
    var pg_name: String = "",
    var method_name: String = "",
    var payment_data : PaymentDataDTO= PaymentDataDTO(),
    var requested_at: String = "",
    var purchased_at: String = "",
    var revoked_at: String = "",
    var status: Int = 0,
    var status_en: String = "",
    var status_ko: String = ""
)

package kr.co.point.common.dto.bootpay.request

data class PaymentDataDTO(
    var receipt_id: String? = null,

    // 가상계좌
    var accountholder: String? = null,
    var account: String? = null,
    var expiredate: String? = null,
    var username: String? = null,

    var bankname: String? = null,
    var cash_result: String? = null,

    var n: String = "",
    var p: Int = 0,
    var pg: String = "",
    var pm: String = "",
    var pg_a: String = "",
    var pm_a: String = "",
    var tid: String = "",
    var o_id: String = "",
    var p_at: String = "",
    var r_at: String = "",
    var s: Int = 0,
    var g: Int = 0
)

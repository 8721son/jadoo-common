package kr.co.point.common.dto.donation.v1.request

import kr.co.point.common.enum_package.type.DonationReceiptType

data class DonationReceiptDTO(
    var type : DonationReceiptType = DonationReceiptType.PERSONAL,
    var name : String = "",
    var idNumber : String? = null,
    var businessNumber : String? = null,
    var address: String = "",
    var detailAddress: String = "",
)

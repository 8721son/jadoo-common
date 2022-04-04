package kr.co.point.common.dto.donation.v1.request

import kr.co.point.common.enum_package.type.DonationReceiptType

data class BusinessCertificateDTO(
    var name : String = "",
    var businessNumber : String? = null,
)

package kr.co.point.common.dto.donation.v1.request

import kr.co.point.common.enum_package.type.DonationReceiptType

data class NameCertificateDTO(
    var name : String = "",
    var idNumber : String? = null,
)

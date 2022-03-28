package kr.co.point.common.dto.partners.response

import kr.co.point.common.dto.file.response.FileDTO

data class PartnersPurchaseStatusDTO(
    var statusName : String = "",
    var statusNameEng : String = "",
    var count : Long = 0
)

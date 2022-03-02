package kr.co.point.common.dto.donation.v1.response

import kr.co.point.common.dto.file.response.FileDTO

data class FoundationListDTO(
    var idx: Int = 0,
    var title : String = "",
    var photo : FileDTO? = null
 )

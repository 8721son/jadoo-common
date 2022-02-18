package kr.co.point.common.dto.donation.response

import kr.co.point.common.dto.file.response.FileDTO
import kr.co.point.common.entity.file.File

data class FoundationListDTO(
    var idx: Int = 0,
    var title : String = "",
    var photo : FileDTO? = null
 )

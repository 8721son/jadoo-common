package kr.co.point.common.dto.coupang.response

import kr.co.point.common.dto.file.response.FileDTO

data class CoupangCategoryDTO(
    var idx: Int = 0,
    var name: String = "",
    var photo: FileDTO = FileDTO(),
 )

package kr.co.point.common.dto.coupang.response

import kr.co.point.common.dto.file.response.FileDTO

data class CoupangBannerDTO(
    var idx: Int = 0,
    var photo: FileDTO = FileDTO(),
    var url: String = "",
 )

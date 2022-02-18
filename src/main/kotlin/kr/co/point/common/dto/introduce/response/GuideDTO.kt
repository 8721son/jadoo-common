package kr.co.point.common.dto.introduce.response

import kr.co.point.common.entity.file.File

data class GuideDTO(
    var idx: Int? = null,
    var bannerImg: File = File(),
    var detailImg: File = File(),
)

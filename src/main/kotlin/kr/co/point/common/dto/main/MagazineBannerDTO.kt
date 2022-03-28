package kr.co.point.common.dto.main

import kr.co.point.common.dto.file.response.FileDTO

data class MagazineBannerDTO(
    var idx: Int = 0,
    var bannerImg: FileDTO = FileDTO(),
    var detailImg: FileDTO = FileDTO(),
    var url: String = "",
 )

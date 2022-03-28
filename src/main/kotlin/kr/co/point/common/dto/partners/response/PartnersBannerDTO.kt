package kr.co.point.common.dto.partners.response

import kr.co.point.common.dto.file.response.FileDTO

data class PartnersBannerDTO(
    var idx: Int = 0,
    var bannerImg: FileDTO = FileDTO(),
    var detailImg: FileDTO = FileDTO(),
    var url: String = "",
 )

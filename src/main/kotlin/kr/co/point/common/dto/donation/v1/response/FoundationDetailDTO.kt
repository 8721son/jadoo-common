package kr.co.point.common.dto.donation.v1.response

import kr.co.point.common.dto.search.response.TagDTO

data class FoundationDetailDTO(
    var idx : Int = 0,
    var nickname: String = "",
    var official: String = "",
    var tags: List<TagDTO>? = null,
    var sns : List<FoundationFileDTO>  = ArrayList(),
    var logo : FoundationFileDTO = FoundationFileDTO(),
    var detail : FoundationFileDTO = FoundationFileDTO(),
    )

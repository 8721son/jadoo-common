package kr.co.point.common.dto.donation.response

import kr.co.point.common.dto.search.response.TagDTO
import org.springframework.data.domain.Page

data class FoundationDetailDTO(
    var nickname: String = "",
    var official: String = "",
    var tags: List<TagDTO>? = null,
    var sns : List<FoundationFileDTO>  = ArrayList(),
    var logo : FoundationFileDTO = FoundationFileDTO(),
    var detail : FoundationFileDTO = FoundationFileDTO(),
    )

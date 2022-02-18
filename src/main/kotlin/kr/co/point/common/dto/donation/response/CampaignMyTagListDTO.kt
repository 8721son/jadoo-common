package kr.co.point.common.dto.donation.response

import kr.co.point.common.dto.search.response.TagDTO
import org.springframework.data.domain.Page

data class CampaignMyTagListDTO(
    var myTag: List<TagDTO> = ArrayList(),
    var content: Page<CampaignDTO>? = null
 )

package kr.co.point.common.dto.donation.v2.response

import kr.co.point.common.dto.donation.v1.response.CampaignDTO
import kr.co.point.common.dto.donation.v1.response.FoundationDetailDTO
import kr.co.point.common.dto.file.response.FileDTO
import kr.co.point.common.dto.search.response.TagDTO
import org.springframework.data.domain.Page

data class LikeCampaignV2DTO(
    var campaign : Page<CampaignDTO>? = null,
    var tag : MutableList<TagDTO>? = null,
 )

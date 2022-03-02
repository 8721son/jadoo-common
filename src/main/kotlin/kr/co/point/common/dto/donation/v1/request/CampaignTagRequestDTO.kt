package kr.co.point.common.dto.donation.v1.request

import kr.co.point.common.dto.search.response.TagDTO

data class CampaignTagRequestDTO(
    var tags: List<TagDTO>
 )

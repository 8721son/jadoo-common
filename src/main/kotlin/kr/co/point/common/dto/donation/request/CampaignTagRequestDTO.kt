package kr.co.point.common.dto.donation.request

import kr.co.point.common.dto.search.response.TagDTO

data class CampaignTagRequestDTO(
    var tags: List<TagDTO>
 )

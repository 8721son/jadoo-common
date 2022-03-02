package kr.co.point.common.dto.donation.v1.response

import kr.co.point.common.dto.file.response.FileDTO
import kr.co.point.common.dto.search.response.TagDTO
import kr.co.point.common.entity.donation.Category

data class CampaignDTO(
    var idx: Int = 0,
    var photo: FileDTO = FileDTO(),
    var title: String = "",
    var sub: String = "",
    var isLike: Boolean = false,
    var endDate: String = "",
    var targetBrix: Int = 0,
    var currentBrix: Int = 0,
    var tags: List<TagDTO>,
    var endYn : String = "N",
    var category : CampaignCategoryDTO? = null
 )

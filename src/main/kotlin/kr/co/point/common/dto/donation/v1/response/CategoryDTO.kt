package kr.co.point.common.dto.donation.v1.response

import kr.co.point.common.dto.file.response.FileDTO
import kr.co.point.common.dto.search.response.TagDTO

data class CategoryDTO (
    var idx: Int = 0,
    var name: String ="",
    var icon : FileDTO = FileDTO(),
    var tags : MutableList<TagDTO>? = null,
)
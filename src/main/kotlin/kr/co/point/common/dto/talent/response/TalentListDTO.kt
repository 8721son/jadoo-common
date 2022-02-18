package kr.co.point.common.dto.talent.response

import kr.co.point.common.entity.file.File
import kr.co.point.common.entity.search.TagCode
import java.time.LocalDateTime

data class TalentListDTO (
    var file: File? = null,
    var title: String = "",
    var address : String = "",
    var startDate : LocalDateTime? = null,
    var endDate : LocalDateTime? = null,
    var tag: List<TagCode>? =null,
    var totalRecruit: Int = 0,
)
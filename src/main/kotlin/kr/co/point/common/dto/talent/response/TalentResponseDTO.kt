package kr.co.point.common.dto.talent.response

import kr.co.point.common.entity.file.File
import kr.co.point.common.entity.search.TagCode
import kr.co.point.common.entity.talent.Category
import kr.co.point.common.entity.talent.TalentComment
import java.time.LocalDateTime

data class TalentResponseDTO (
    var idx: Int? = null,
    var organizer: String = "",
    var title: String = "",
    var recruitStartDate : LocalDateTime? = null,
    var recruitEndDate : LocalDateTime? = null,
    var startDate : LocalDateTime? = null,
    var endDate : LocalDateTime? = null,
    var startTime : String = "",
    var endTime : String = "",
    var address: String? = "",
    var detailAddress: String? = "",
    var totalRecruit: Int = 0,
    var description : String = "",
    var category: Category? = null,
    var comments: MutableList<TalentComment>? = null,
    var file: File? = null,
    var tag: List<TagCode>? =null
   )
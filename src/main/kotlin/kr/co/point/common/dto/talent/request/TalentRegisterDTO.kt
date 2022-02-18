package kr.co.point.common.dto.talent.request

import kr.co.point.common.entity.file.File

data class TalentRegisterDTO(
    var title: String = "",
    var recruitStartDate : String = "",
    var recruitEndDate : String = "",
    var startDate : String = "",
    var endDate : String = "",
    var startTime : String = "",
    var endTime : String = "",
    var address: String? = "",
    var detailAddress: String? = "",
    var totalRecruit: Int = 0,
    var description : String = "",
    var category: String = "",
    var file: File? = null,
    var tag: List<Int>? = null,

    var onlineYn: String = "N",
    var url: String? = "",

    var longitude : Double = 0.0,
    var latitude : Double = 0.0,

    )

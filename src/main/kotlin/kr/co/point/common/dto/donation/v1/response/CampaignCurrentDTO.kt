package kr.co.point.common.dto.donation.v1.response

import kr.co.point.common.dto.file.response.FileDTO

data class CampaignCurrentDTO(
    var idx: Int = 0,
    var photo: FileDTO = FileDTO(),
    var title: String = "",
    var content: String = "",
    var endDate: String = "",
    var targetBrix: Int = 0,
    var currentBrix: Int = 0,
    var endYn: String = "N"
 )

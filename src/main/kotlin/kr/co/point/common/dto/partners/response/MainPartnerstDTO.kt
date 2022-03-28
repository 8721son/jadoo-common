package kr.co.point.common.dto.partners.response

import kr.co.point.common.dto.file.response.FileDTO

data class MainPartnerstDTO(
    var idx : Int = 0,
    var logo : FileDTO = FileDTO(),
    var name : String = "",
)

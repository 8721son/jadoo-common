package kr.co.point.common.dto.coupang.response

import kr.co.point.common.dto.file.response.FileDTO

data class CoupangVideoDTO(
    var idx: Int = 0,
    var photo: FileDTO = FileDTO(),
    var thumbnail: FileDTO = FileDTO(),
    var video: FileDTO = FileDTO(),
    var url: String = "",

    var title: String = "",
    var price: Int = 0,
    var isRocket: Boolean = false,
    var isFreeShipping: Boolean = false,
 )

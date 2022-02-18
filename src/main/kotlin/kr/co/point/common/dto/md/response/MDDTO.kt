package kr.co.point.common.dto.md.response

import kr.co.point.common.dto.file.response.FileDTO

data class MDDTO(
    var idx: Int? = 0,
    var photo: FileDTO = FileDTO(),
    var title: String = "",
    var category: String = "",
    var discountRate: Double = 0.0,
    var price: Int = 0,
    var isNew: Boolean = true,
 )

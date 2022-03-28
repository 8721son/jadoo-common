package kr.co.point.common.dto.partners.response

import kr.co.point.common.dto.file.response.FileDTO

data class ProductCategoryDTO(
    var code: Int = 0,
    var categoryImg: FileDTO = FileDTO(),
    var name: String = "",
 )

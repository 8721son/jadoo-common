package kr.co.point.common.dto.search.response

import kr.co.point.common.entity.search.TagCode

data class PopularTagCodeDTO(
    var idx : Int = 0,
    var title : String = "",
    var cnt : Int = 0,
 )

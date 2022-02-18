package kr.co.point.common.dto.search.response

import kr.co.point.common.entity.search.TagCode

data class PopularTagDTO(
    var Tag : List<PopularTagCodeDTO> = ArrayList()
 )

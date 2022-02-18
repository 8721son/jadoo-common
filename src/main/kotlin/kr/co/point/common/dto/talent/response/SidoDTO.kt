package kr.co.point.common.dto.talent.response

import kr.co.point.common.entity.talent.Sigungu

data class SidoDTO (
    var name: String ="",
    var sigungu : List<SigunguDTO>? = null

)
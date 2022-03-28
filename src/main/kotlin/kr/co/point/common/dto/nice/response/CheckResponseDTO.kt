package kr.co.point.common.dto.nice.response

data class CheckResponseDTO(
    var dataHeader : CheckHeaderDTO = CheckHeaderDTO(),
    var dataBody : CheckBodyDTO = CheckBodyDTO(),
)

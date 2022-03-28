package kr.co.point.common.dto.nice.response

data class TokenResponseDTO(
    var dataHeader : TokenHeaderDTO = TokenHeaderDTO(),
    var dataBody : TokenBodyDTO = TokenBodyDTO(),
)

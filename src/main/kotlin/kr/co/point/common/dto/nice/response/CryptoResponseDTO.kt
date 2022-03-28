package kr.co.point.common.dto.nice.response

data class CryptoResponseDTO(
    var dataHeader : CryptoHeaderDTO = CryptoHeaderDTO(),
    var dataBody : CryptoBodyDTO = CryptoBodyDTO(),
)

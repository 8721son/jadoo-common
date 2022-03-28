package kr.co.point.common.dto.nice.response

import kr.co.point.common.dto.file.response.FileDTO

data class TokenBodyDTO(
    var access_token : String = "",
    var token_type : String = "",
    var expires_in : Long = 0,
    var scope : String = "",
)

package kr.co.point.common.dto.member.response

import com.fasterxml.jackson.annotation.JsonProperty

data class ImportDataResultDTO(

    @JsonProperty("code")
    var code: Int = 0,

    @JsonProperty("message")
    var message: String? = null,

    @JsonProperty("response")
    var response: ImportDataDTO? = null,
)

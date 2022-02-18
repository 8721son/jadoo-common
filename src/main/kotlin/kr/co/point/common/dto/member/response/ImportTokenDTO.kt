package kr.co.point.common.dto.member.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ImportTokenDTO(

    @JsonProperty("access_token")
    var access_token: String = "",

    @JsonProperty("now")
    var now: String = "",

    @JsonProperty("expired_at")
    var expired_at : String = "",
)

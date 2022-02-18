package kr.co.point.common.response

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.hateoas.RepresentationModel


class ResponseDTO<T> : RepresentationModel<ResponseDTO<T>> {

    @JsonProperty("code")
    var code: Int = 0

    @JsonProperty("message")
    var message: String = ""

    @JsonProperty("content")
    var content: T? = null

    constructor()

    constructor(respEnum: ResponseEnum) {
        this.code = respEnum.code
        message = if (respEnum.message == null ) "" else respEnum.message!!
    }

    constructor(message: String) {
        this.message =message
    }

    constructor(code: Int, message: String, content: T?) {
        this.message =message
        this.code =code
        this.content =content
    }

    constructor(respEnum: ResponseEnum, content: T) {
        this.code = respEnum.code
        message = if (respEnum.message == null ) "" else respEnum.message!!
        this.content = content
    }

}

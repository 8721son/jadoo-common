package kr.co.point.common.error

import lombok.Getter
import org.springframework.hateoas.RepresentationModel
import org.springframework.validation.Errors

@Getter
class ErrorsResource(errors: Errors) : RepresentationModel<ErrorsResource>() {

    var message = ""
    var code = ""

    init {
        val allErrors = errors.allErrors
        if (allErrors.size > 0) {
            val objectError = allErrors[0]
            message = if (objectError.defaultMessage == null) "" else objectError.defaultMessage!!
            code    = if (objectError.code == null) "" else objectError.code!!
        }
    }
}
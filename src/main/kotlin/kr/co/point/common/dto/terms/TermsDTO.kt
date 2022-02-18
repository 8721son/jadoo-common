package kr.co.point.common.dto.terms

data class TermsDTO(
    var title: String? = null,
    var content: String? = null,
    var sub: List<TermsSubDTO>? = null,
)

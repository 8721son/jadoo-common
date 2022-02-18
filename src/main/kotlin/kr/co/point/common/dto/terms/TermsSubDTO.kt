package kr.co.point.common.dto.terms

data class TermsSubDTO(
    var content: String? =null,
    var articles : List<TermsArticleDTO>? = null
)

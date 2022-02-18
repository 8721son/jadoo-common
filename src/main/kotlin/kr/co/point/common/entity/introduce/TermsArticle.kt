package kr.co.point.common.entity.introduce

import kr.co.point.common.dto.terms.TermsArticleDTO
import javax.persistence.*

@Entity
data class TermsArticle(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,
    var content: String? =null,

    @ManyToOne(targetEntity = TermsSub::class)
    @JoinColumn(name = "terms_sub_idx", referencedColumnName = "idx")
    var termsSub: TermsSub = TermsSub(),

    var sequence: Int? = null
) {
    fun toDTO(): TermsArticleDTO {
        val termsArticleDTO = TermsArticleDTO();
        termsArticleDTO.content = content
        return termsArticleDTO
    }
}

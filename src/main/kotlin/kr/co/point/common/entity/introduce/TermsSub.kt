package kr.co.point.common.entity.introduce

import kr.co.point.common.dto.terms.TermsDTO
import kr.co.point.common.dto.terms.TermsSubDTO
import javax.persistence.*

@Entity
data class TermsSub(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,
    var content: String? =null,

    @ManyToOne(targetEntity = Terms::class)
    @JoinColumn(name = "terms_idx", referencedColumnName = "idx")
    var terms: Terms = Terms(),

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "termsSub", cascade = [CascadeType.ALL], orphanRemoval = true)
    @OrderBy("sequence ASC")
    var articles : MutableList<TermsArticle>? = null,

    var sequence: Int? = null

) {
    fun toDTO(): TermsSubDTO {
        val termsSubDTO = TermsSubDTO();
        termsSubDTO.content = content
        termsSubDTO.articles = articles!!.stream().map(TermsArticle::toDTO).toList();
        return termsSubDTO
    }
}


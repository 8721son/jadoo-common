package kr.co.point.common.entity.introduce

import kr.co.point.common.dto.terms.TermsArticleDTO
import org.hibernate.Hibernate
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as TermsArticle

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , content = $content , termsSub = $termsSub , sequence = $sequence )"
    }
}

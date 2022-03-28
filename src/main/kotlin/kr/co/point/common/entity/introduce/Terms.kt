package kr.co.point.common.entity.introduce

import kr.co.point.common.dto.terms.TermsDTO
import org.hibernate.Hibernate
import javax.persistence.*

@Entity
data class Terms(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,
    var title: String? = null,
    var content: String? = null,

    var yakkwanYn: String = "N",
    var gaeinYn: String = "N",
    var coupangYn: String = "N",


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "terms", cascade = [CascadeType.ALL], orphanRemoval = true)
    @OrderBy("sequence ASC")
    var sub: MutableList<TermsSub>? = null,

    var sequence: Int? = null,

){
    fun toDTO(): TermsDTO {
        val termsDTO = TermsDTO();
        termsDTO.title = title
        termsDTO.content = content
        termsDTO.sub = sub!!.stream().map(TermsSub::toDTO).toList();
        return termsDTO
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Terms

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , title = $title , content = $content , yakkwanYn = $yakkwanYn , gaeinYn = $gaeinYn , coupangYn = $coupangYn , sequence = $sequence )"
    }

}

package kr.co.point.common.entity.introduce

import kr.co.point.common.dto.terms.TermsDTO
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
}

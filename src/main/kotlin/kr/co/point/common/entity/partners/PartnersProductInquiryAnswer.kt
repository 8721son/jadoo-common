package kr.co.point.common.entity.partners

import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class PartnersProductInquiryAnswer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @OneToOne(targetEntity = PartnersProductInquiry::class)
    @JoinColumn(name = "inquiry_idx", referencedColumnName = "idx")
    var inquiry: PartnersProductInquiry = PartnersProductInquiry(),

    var content : String = "",

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as PartnersProductInquiryAnswer

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , inquiry = $inquiry , content = $content , createDate = $createDate )"
    }
}
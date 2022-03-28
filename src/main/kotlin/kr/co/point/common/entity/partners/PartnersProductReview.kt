package kr.co.point.common.entity.partners

import kr.co.point.common.dto.partners.response.PartnersReviewDTO
import kr.co.point.common.dto.partners.response.PartnersReviewListDTO
import kr.co.point.common.entity.file.File
import kr.co.point.common.entity.member.Member
import kr.co.point.common.util.getDate
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class PartnersProductReview(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @ManyToOne(targetEntity = PartnersPurchaseProductList::class)
    @JoinColumn(name = "purchase_idx", referencedColumnName = "idx")
    var purchase : PartnersPurchaseProductList = PartnersPurchaseProductList(),

    @ManyToOne(targetEntity = Member::class)
    @JoinColumn(name = "member_idx", referencedColumnName = "idx")
    var member : Member = Member(),

    @OneToOne(targetEntity = File::class)
    @JoinColumn(name = "product_img", referencedColumnName = "idx")
    var productImg : File? = File(),

    var review : String = "",

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updateDate : LocalDateTime? = null,

    var deleteYn : String = "N",
){
    fun toDTO() : PartnersReviewDTO{
        return PartnersReviewDTO(
            idx!!,
            purchase.toProductDTO(),
            member.idx,
            null,
            if(productImg!=null) productImg!!.toDTO() else null,
            review,
            deleteYn,
            purchase.idx!!,
            getDate(createDate),
            null
        )
    }

    fun toListDTO() : PartnersReviewListDTO {
        return PartnersReviewListDTO(
            idx!!,
            member.idx,
            null,
            if(productImg!=null) productImg!!.toDTO() else null,
            review,
            deleteYn,
            purchase.idx!!,
            getDate(createDate),
            null
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as PartnersProductReview

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , purchase = $purchase , member = $member , productImg = $productImg , review = $review , createDate = $createDate , updateDate = $updateDate , deleteYn = $deleteYn )"
    }
}
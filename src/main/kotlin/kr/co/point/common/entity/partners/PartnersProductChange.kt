package kr.co.point.common.entity.partners

import kr.co.point.common.dto.partners.response.PartnersChangeProductListDTO
import kr.co.point.common.entity.member.Member
import kr.co.point.common.enum_package.type.ChangeType
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.*

@Entity
data class PartnersProductChange(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @ManyToOne(targetEntity = Member::class)
    @JoinColumn(name = "member_idx", referencedColumnName = "idx")
    var member: Member? = null,

    @ManyToOne(targetEntity = PartnersPurchaseProductList::class)
    @JoinColumn(name = "purchase_product_list_idx", referencedColumnName = "idx")
    var purchaseProductList: PartnersPurchaseProductList = PartnersPurchaseProductList(),

    @Enumerated(EnumType.STRING)
    var type : ChangeType = ChangeType.EXCHANGE,

    var refundPrice : Int? = 0,

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),
){
    fun toListDTO() : PartnersChangeProductListDTO {
        return PartnersChangeProductListDTO(
            idx!!,
            purchaseProductList.purchase.orderNumber,
            purchaseProductList.product.thumbnail.toDTO(),
            purchaseProductList.product.name,
            createDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd")),
            type.cancelType
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as PartnersProductChange

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , member = $member , purchaseProductList = $purchaseProductList , type = $type , refundPrice = $refundPrice , createDate = $createDate )"
    }
}
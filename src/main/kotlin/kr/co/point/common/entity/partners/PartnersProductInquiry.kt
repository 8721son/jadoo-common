package kr.co.point.common.entity.partners

import kr.co.point.common.entity.member.Member
import kr.co.point.common.enum_package.type.InquiryType
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class PartnersProductInquiry(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @OneToOne(targetEntity = PartnersPurchaseProductList::class)
    @JoinColumn(name = "purchase_product_list_idx", referencedColumnName = "idx")
    var purchaseProductList: PartnersPurchaseProductList? = null,

    @ManyToOne(targetEntity = PartnersProduct::class)
    @JoinColumn(name = "product_idx", referencedColumnName = "idx")
    var product: PartnersProduct? = null,

    @ManyToOne(targetEntity = Member::class)
    @JoinColumn(name = "member_idx", referencedColumnName = "idx")
    var member: Member? = null,

    @Enumerated(EnumType.STRING)
    var type : InquiryType = InquiryType.PRODUCT,

    var title : String = "",
    var content : String = "",

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as PartnersProductInquiry

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , purchaseProductList = $purchaseProductList , product = $product , member = $member , type = $type , title = $title , content = $content , createDate = $createDate )"
    }
}
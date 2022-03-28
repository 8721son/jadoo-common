package kr.co.point.common.entity.partners

import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class PartnersPurchaseProductListSaleOptionList(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @OneToOne(targetEntity = PartnersPurchaseProductListSaleOption::class)
    @JoinColumn(name = "purchase_product_list_sale_option_idx", referencedColumnName = "idx")
    var purchaseProductListSaleOption : PartnersPurchaseProductListSaleOption = PartnersPurchaseProductListSaleOption(),

    @ManyToOne(targetEntity = PartnersProductSaleOptionList::class)
    @JoinColumn(name = "product_sale_option_list_idx", referencedColumnName = "idx")
    var productSaleOptionList : PartnersProductSaleOptionList = PartnersProductSaleOptionList(),

    var additionalPrice : Int = 0,

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as PartnersPurchaseProductListSaleOptionList

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , purchaseProductListSaleOption = $purchaseProductListSaleOption , productSaleOptionList = $productSaleOptionList , additionalPrice = $additionalPrice , createDate = $createDate )"
    }
}
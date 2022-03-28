package kr.co.point.common.entity.partners

import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class PartnersPurchaseProductListSaleOption(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @ManyToOne(targetEntity = PartnersPurchaseProductList::class)
    @JoinColumn(name = "purchase_product_list_idx", referencedColumnName = "idx")
    var purchaseProductList : PartnersPurchaseProductList = PartnersPurchaseProductList(),

    @ManyToOne(targetEntity = PartnersProductSaleOption::class)
    @JoinColumn(name = "product_sale_option_idx", referencedColumnName = "idx")
    var productSaleOption : PartnersProductSaleOption = PartnersProductSaleOption(),

//    @OneToMany(mappedBy = "purchaseProductListSaleOption", cascade = [CascadeType.ALL], orphanRemoval = true)
//    var optionDetail : PartnersPurchaseProductListSaleOptionList = PartnersPurchaseProductListSaleOptionList(),

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as PartnersPurchaseProductListSaleOption

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , purchaseProductList = $purchaseProductList , productSaleOption = $productSaleOption , createDate = $createDate )"
    }
}
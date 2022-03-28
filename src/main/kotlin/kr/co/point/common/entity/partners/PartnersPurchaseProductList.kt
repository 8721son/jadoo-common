package kr.co.point.common.entity.partners

import kr.co.point.common.dto.partners.response.ProductDTO
import kr.co.point.common.dto.partners.response.ProductRawDTO
import kr.co.point.common.enum_package.status.PurchaseStatus
import kr.co.point.common.util.dotNumberStrNormal
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.time.Duration
import java.time.LocalDateTime
import javax.persistence.*
import kotlin.collections.ArrayList

@Entity
data class PartnersPurchaseProductList(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @ManyToOne(targetEntity = PartnersPurchaseProduct::class)
    @JoinColumn(name = "purchase_idx", referencedColumnName = "idx")
    var purchase : PartnersPurchaseProduct = PartnersPurchaseProduct(),

    @ManyToOne(targetEntity = PartnersProduct::class)
    @JoinColumn(name = "product_idx", referencedColumnName = "idx")
    var product : PartnersProduct = PartnersProduct(),

    var price : Int = 0,

    var quantity : Int = 0,

    @Enumerated(EnumType.STRING)
    var status : PurchaseStatus = PurchaseStatus.PAYMENT_WAIT,

    @ManyToOne(targetEntity = DeliveryCompany::class)
    @JoinColumn(name = "delivery_idx", referencedColumnName = "code")
    var delivery : DeliveryCompany? = null,

    var deliveryNo : String? = null,

    @OneToMany(mappedBy = "purchaseProductList", cascade = [CascadeType.ALL], orphanRemoval = true)
    var option : MutableList<PartnersPurchaseProductListSaleOption> = ArrayList(),

    @OneToMany(mappedBy = "purchaseProductList", cascade = [CascadeType.ALL], orphanRemoval = true)
    var change : MutableList<PartnersProductChange> = ArrayList(),

    @OneToMany(mappedBy = "purchase", cascade = [CascadeType.ALL], orphanRemoval = true)
    var review : MutableList<PartnersProductReview> = ArrayList(),

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),

    var confirmDate : LocalDateTime? = LocalDateTime.now(),

    var deliveryDate : LocalDateTime? = LocalDateTime.now(),
){
    fun toProductDTO() : ProductDTO {
        val percent = (100-product.discountRate)/100.0

        var confirmDay = false
        if(confirmDate==null){
            confirmDay=true
        }else{
            if(Duration.between(confirmDate!!,LocalDateTime.now()).toDays()<=30){
                confirmDay=true
            }
        }

        var deliveryDay = false

        if(deliveryDate!=null){
            if(Duration.between(deliveryDate!!,LocalDateTime.now()).toDays()<=7){
                deliveryDay=true
            }
        }

        val statusIncludeChange : String = if(change.isNotEmpty()){
            change[0].type.cancelType
        }else{
            status.purchaseStatus
        }
        return ProductDTO(
            idx!!,
            product.thumbnail.toDTO(),
            product.partners.business_name,
            product.name,
            "",
            dotNumberStrNormal(quantity),
            dotNumberStrNormal(product.price),
            dotNumberStrNormal(product.price * percent),
            dotNumberStrNormal(product.price * percent * quantity),
            statusIncludeChange,
            review.isEmpty() && confirmDay && status == PurchaseStatus.CONFIRMATION,
             deliveryDay && change.isEmpty() && status == PurchaseStatus.DELIVERY_COMPLETION,
            status == PurchaseStatus.DELIVERY || status == PurchaseStatus.DELIVERY_COMPLETION,
            status==PurchaseStatus.PAYMENT_WAIT || status == PurchaseStatus.PAYMENT_DONE || status == PurchaseStatus.PRODUCT_WAIT
        )
    }

    fun toRawDTO() : ProductRawDTO{
        val percent = (100-product.discountRate)/100.0
        return ProductRawDTO(
            quantity,
            product.price,
            product.price * percent,
            product.price * (product.discountRate/100),
            product.price * percent * quantity
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as PartnersPurchaseProductList

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , purchase = $purchase , product = $product , price = $price , quantity = $quantity , status = $status , delivery = $delivery , deliveryNo = $deliveryNo , createDate = $createDate , confirmDate = $confirmDate , deliveryDate = $deliveryDate )"
    }
}
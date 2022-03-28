package kr.co.point.common.entity.partners

import kr.co.point.common.dto.partners.response.PartnersPurchaseProductListDTO
import kr.co.point.common.entity.bootpay.Bootpay
import kr.co.point.common.entity.member.Member
import kr.co.point.common.entity.member.MemberDeliveryAddress
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.persistence.*

@Entity
data class PartnersPurchaseProduct(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @ManyToOne(targetEntity = Member::class)
    @JoinColumn(name = "member_idx", referencedColumnName = "idx")
    var member : Member? = null,

    var totalPrice : Int = 0,

    var orderNumber : String = "",

    @OneToOne(targetEntity = Bootpay::class)
    @JoinColumn(name = "bootpay_idx", referencedColumnName = "idx")
    var bootpay : Bootpay = Bootpay(),

    var deliveryRequest : String? = "",

    @ManyToOne(targetEntity = MemberDeliveryAddress::class)
    @JoinColumn(name = "address_idx", referencedColumnName = "idx")
    var address : MemberDeliveryAddress = MemberDeliveryAddress(),

    @OneToMany(mappedBy = "purchase", cascade = [CascadeType.ALL], orphanRemoval = true)
    var productList : MutableList<PartnersPurchaseProductList> = ArrayList(),

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),
) {
    fun toListDTO() : PartnersPurchaseProductListDTO{
        return PartnersPurchaseProductListDTO(
            idx!!,
            orderNumber,
            productList[0].product.thumbnail.toDTO(),
            productList[0].product.name + " 외 " + (productList.size-1) + "건",
            createDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"))
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as PartnersPurchaseProduct

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , member = $member , totalPrice = $totalPrice , orderNumber = $orderNumber , bootpay = $bootpay , deliveryRequest = $deliveryRequest , address = $address , createDate = $createDate )"
    }
}
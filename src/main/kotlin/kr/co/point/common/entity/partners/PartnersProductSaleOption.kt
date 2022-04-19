package kr.co.point.common.entity.partners

import kr.co.point.common.dto.partners.response.PartnersProductOptionDTO
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class PartnersProductSaleOption(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @ManyToOne(targetEntity = PartnersProduct::class)
    @JoinColumn(name = "product_idx", referencedColumnName = "idx")
    var product : PartnersProduct = PartnersProduct(),

    var sort : Int = 0,

    @OneToMany(mappedBy = "saleOption", cascade = [CascadeType.ALL], orphanRemoval = true)
    var detail : MutableList<PartnersProductSaleOptionList>? = ArrayList(),

    var name : String = "",

    var showYn : String = "N",

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updateDate : LocalDateTime? = null,
) {
    fun toDTO() : PartnersProductOptionDTO{
        return PartnersProductOptionDTO(
            idx,
            name,
            detail!!.map { partnersProductSaleOptionList -> partnersProductSaleOptionList.toDTO() },
            sort
        )
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as PartnersProductSaleOption

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , product = $product , sort = $sort , name = $name , showYn = $showYn , createDate = $createDate , updateDate = $updateDate )"
    }
}
package kr.co.point.common.entity.partners

import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class PartnersProductSaleOptionList(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @ManyToOne(targetEntity = PartnersProductSaleOption::class)
    @JoinColumn(name = "sale_option_idx", referencedColumnName = "idx")
    var saleOption : PartnersProductSaleOption = PartnersProductSaleOption(),

    var additionalPrice : Int = 0,

    var sort : Int = 0,

    var name : String = "",

    var stock : Int = 0,

    var showYn : String = "N",

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updateDate : LocalDateTime? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as PartnersProductSaleOptionList

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , saleOption = $saleOption , additionalPrice = $additionalPrice , sort = $sort , name = $name , showYn = $showYn , createDate = $createDate , updateDate = $updateDate )"
    }
}
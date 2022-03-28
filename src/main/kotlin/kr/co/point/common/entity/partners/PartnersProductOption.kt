package kr.co.point.common.entity.partners

import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class PartnersProductOption(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @ManyToOne(targetEntity = PartnersProduct::class)
    @JoinColumn(name = "product_idx", referencedColumnName = "idx")
    var product : PartnersProduct = PartnersProduct(),

    var name : String = "",
    var value : String = "",

    var showYn : String = "N",

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updateDate : LocalDateTime? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as PartnersProductOption

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , product = $product , name = $name , value = $value , showYn = $showYn , createDate = $createDate , updateDate = $updateDate )"
    }
}
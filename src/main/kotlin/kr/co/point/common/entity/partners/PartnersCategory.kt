package kr.co.point.common.entity.partners

import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class PartnersCategory(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @ManyToOne(targetEntity = PartnersProduct::class)
    @JoinColumn(name = "product_idx", referencedColumnName = "idx")
    var product : PartnersProduct = PartnersProduct(),

    @OneToOne(targetEntity = ProductCategoryDetail::class)
    @JoinColumn(name = "category_code", referencedColumnName = "code")
    var categoryDetail : ProductCategoryDetail = ProductCategoryDetail(),

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),

    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as PartnersCategory

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , product = $product , categoryDetail = $categoryDetail , createDate = $createDate )"
    }
}
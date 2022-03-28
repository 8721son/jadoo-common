package kr.co.point.common.entity.partners

import kr.co.point.common.enum_package.type.AdjustmentType
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class PartnersAdjustment(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @ManyToOne(targetEntity = Partners::class)
    @JoinColumn(name = "partners_idx", referencedColumnName = "idx")
    var partners : Partners = Partners(),

    @OneToOne(targetEntity = PartnersBank::class)
    @JoinColumn(name = "partners_bank_idx", referencedColumnName = "idx")
    var partnersBank : PartnersBank = PartnersBank(),

    var price : Int = 0,

    @Enumerated(EnumType.STRING)
    var type: AdjustmentType = AdjustmentType.DEPOSIT,

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as PartnersAdjustment

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , partners = $partners , partnersBank = $partnersBank , price = $price , type = $type , createDate = $createDate )"
    }
}
package kr.co.point.common.entity.partners

import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class PartnersBank(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @ManyToOne(targetEntity = Partners::class)
    @JoinColumn(name = "partners_idx", referencedColumnName = "idx")
    var partners : Partners = Partners(),

    @OneToOne(targetEntity = Bank::class)
    @JoinColumn(name = "bank_code", referencedColumnName = "code")
    var bank : Bank = Bank(),

    var bankNum : Int = 0,

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updateDate : LocalDateTime? = null,

    var deleteYn : String = "N",
    var deleteDate : LocalDateTime? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as PartnersBank

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , partners = $partners , bank = $bank , bankNum = $bankNum , createDate = $createDate , updateDate = $updateDate , deleteYn = $deleteYn , deleteDate = $deleteDate )"
    }
}
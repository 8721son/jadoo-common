package kr.co.point.common.entity.md

import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class MDCategory(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,
    var name: String = "",

    @CreationTimestamp
    var createDate : LocalDateTime? = null,

    @UpdateTimestamp
    var updateDate : LocalDateTime? = null,

    var deleteYn: String = "N",
    var deleteDate : LocalDateTime? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as MDCategory

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , name = $name , createDate = $createDate , updateDate = $updateDate , deleteYn = $deleteYn , deleteDate = $deleteDate )"
    }
}
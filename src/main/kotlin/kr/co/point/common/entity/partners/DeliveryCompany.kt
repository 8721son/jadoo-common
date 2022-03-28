package kr.co.point.common.entity.partners

import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class DeliveryCompany(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var code: Int? = null,

    var name : String = "",

    var showYn: String = "N",

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updateDate : LocalDateTime? = null,


) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as DeliveryCompany

        return code != null && code == other.code
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(code = $code , name = $name , showYn = $showYn , createDate = $createDate , updateDate = $updateDate )"
    }
}
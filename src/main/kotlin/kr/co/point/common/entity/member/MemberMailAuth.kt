package kr.co.point.common.entity.member

import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class MemberMailAuth(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, insertable = false)
        var idx: Int? = null,

        var email: String? = null,
        var code: Int = 0,
        var checkYn: String = "N",

        @CreationTimestamp
        var createDate: LocalDateTime? = null,

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
) {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as MemberMailAuth

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , email = $email , code = $code , checkYn = $checkYn , createDate = $createDate , updateDate = $updateDate )"
        }

}
package kr.co.point.common.entity.search

import kr.co.point.common.dto.search.response.TagDTO
import kr.co.point.common.dto.search.response.TagKeywordDTO
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class TagCode(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var idx: Int? = null,
        var name: String = "",

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
) {

        fun toTagDTO(): TagDTO {
                return TagDTO(idx!!, name)
        }

        fun toKeywordDTO(): TagKeywordDTO {
            return TagKeywordDTO(idx!!, name)
        }

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as TagCode

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , name = $name , createDate = $createDate , updateDate = $updateDate )"
        }
}

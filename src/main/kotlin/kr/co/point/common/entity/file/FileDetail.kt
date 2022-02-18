package kr.co.point.common.entity.file

import kr.co.point.common.dto.file.response.FileDetailDTO
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class FileDetail(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var idx: Int? = null,
        var fileIdx: Int? = null,
        var originalName: String? = null,
        var extension: String? = null,
        var size: Long? = null,
        var fileUrl: String? = null,

        @CreationTimestamp
        var createDate: LocalDateTime? = null,

) {
        fun toDTO(): FileDetailDTO {
                return FileDetailDTO(
                        idx,
                        fileIdx!!,
                        originalName!!,
                        extension!!,
                        size!!,
                        fileUrl!!,
                        createDate!!
                )
        }

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as FileDetail

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , fileIdx = " +
                        "$fileIdx , originalName = $originalName , " +
                        "extension = $extension , size = $size , fileUrl = " +
                        "$fileUrl , createDate = $createDate )"
        }
}
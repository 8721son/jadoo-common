package kr.co.point.common.entity.file

import kr.co.point.common.dto.file.response.FileDTO
import kr.co.point.common.enum_package.type.FileType
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class File(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var idx: Int? = null,

        @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
        @JoinColumn(name = "fileIdx")
        var files: MutableList<FileDetail> = ArrayList(),

        @Enumerated(EnumType.STRING)
        var category: FileType? = null,

        @CreationTimestamp
        var createDate: LocalDateTime? = null
) {
        fun toDTO () : FileDTO {
                return FileDTO(
                        idx!!,
                        category!!,
                        files.map {
                                entity -> entity.toDTO()
                        }
                )
        }

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as File

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , category = $category , createDate = $createDate )"
        }

}


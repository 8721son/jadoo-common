package kr.co.point.common.entity.qna

import kr.co.point.common.entity.file.File
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class QnaRe(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, insertable = false)
        var idx: Int? = null,

        var title: String = "",
        var content: String = "",

        @OneToOne(targetEntity = File::class)
        @JoinColumn(name = "file_idx", referencedColumnName = "idx")
        var file: File? = null,

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
) {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as QnaRe

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , title = $title , content = $content , createDate = $createDate , updateDate = $updateDate)"
        }
}
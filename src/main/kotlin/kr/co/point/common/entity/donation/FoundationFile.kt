package kr.co.point.common.entity.donation

import kr.co.point.common.dto.donation.response.FoundationFileDTO
import kr.co.point.common.entity.file.File
import kr.co.point.common.enum_package.type.FoundationFileType
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class FoundationFile(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var idx: Int? = null,

        @ManyToOne(targetEntity = Foundation::class)
        @JoinColumn(name = "foundation_idx", referencedColumnName = "idx")
        var foundation: Foundation = Foundation(),

        @Enumerated(EnumType.STRING)
        var type : FoundationFileType? = null,

        var url : String? = null,

        @OneToOne(targetEntity = File::class)
        @JoinColumn(name = "file_idx", referencedColumnName = "idx")
        var file: File = File(),

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
){
        fun toDTO() : FoundationFileDTO {
                return FoundationFileDTO(
                        file.idx!!,
                        url,
                        file.category!!,
                        file.files.map {
                                        entity -> entity.toDTO()
                        }
                )
        }
}
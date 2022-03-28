package kr.co.point.common.entity.donation

import kr.co.point.common.dto.donation.v1.response.FoundationDetailDTO
import kr.co.point.common.dto.donation.v1.response.FoundationListDTO
import kr.co.point.common.dto.search.response.TagDTO
import kr.co.point.common.entity.file.File
import kr.co.point.common.enum_package.type.FoundationFileType
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Foundation(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var idx: Int? = null,

        var code: Int? = 0,
        var name: String = "",

        var official: String = "",

        @OneToMany(mappedBy = "foundation", cascade = [CascadeType.ALL], orphanRemoval = true)
        var file: MutableList<FoundationFile>? = null,

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
){
        fun toListDTO() : FoundationListDTO {
                var photo = File()

                file!!.forEach { i ->
                        if(i.type==FoundationFileType.LOGO){
                           photo = i.file
                        }
                }

                return FoundationListDTO(
                        idx!!,name, photo.toDTO()
                )
        }

        fun toDetailDTO(tags : List<TagDTO>?) : FoundationDetailDTO {
                var detailFile = FoundationFile()
                var logoFile = FoundationFile()
                val snsFiles = ArrayList<FoundationFile>()

                file!!.forEach { i ->
                        if(i.type==FoundationFileType.DETAIL){
                                detailFile=i
                        }else if(i.type==FoundationFileType.LOGO){
                                logoFile=i
                        }else if(i.type==FoundationFileType.SNS){
                                snsFiles.add(i)
                        }

                }

                return FoundationDetailDTO(
                        idx!!,
                        name,
                        official,
                        tags,
                        snsFiles.stream().map(FoundationFile::toDTO).toList(),
                        logoFile.toDTO(),
                        detailFile.toDTO()
                )
        }
}
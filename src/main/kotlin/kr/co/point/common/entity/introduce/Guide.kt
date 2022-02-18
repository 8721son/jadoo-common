package kr.co.point.common.entity.introduce

import kr.co.point.common.dto.introduce.response.GuideDTO
import kr.co.point.common.entity.file.File
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Guide(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, insertable = false)
        var idx: Int? = null,

        var sort: Int = 0,

        @OneToOne(targetEntity = File::class)
        @JoinColumn(name = "banner_idx", referencedColumnName = "idx")
        var bannerImg: File = File(),

        @OneToOne(targetEntity = File::class)
        @JoinColumn(name = "detail_idx", referencedColumnName = "idx")
        var detailImg: File = File(),

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,

        var deleteYn: String = "N",

        var deleteDate: LocalDateTime? = null,

) {
        fun toDTO(): GuideDTO {
                val guideDTO = GuideDTO();
                guideDTO.idx=idx
                guideDTO.bannerImg=bannerImg
                guideDTO.detailImg=detailImg
                return guideDTO
        }
}
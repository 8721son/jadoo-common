package kr.co.point.common.entity.main

import kr.co.point.common.dto.main.BannerDTO
import kr.co.point.common.entity.file.File
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class MainBanner(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @OneToOne(targetEntity = File::class)
    @JoinColumn(name = "banner_idx", referencedColumnName = "idx")
    var bannerImg: File = File(),

    @OneToOne(targetEntity = File::class)
    @JoinColumn(name = "detail_idx", referencedColumnName = "idx")
    var detailImg: File = File(),

    var url: String = "",
    var deleteYn: String = "N",
    var showYn: String = "N",

    @CreationTimestamp
    var createDate: LocalDateTime? = null,

    @UpdateTimestamp
    var updateDate: LocalDateTime? = null,

    var deleteDate: LocalDateTime? = null,
) {

    fun toDTO() : BannerDTO {
        return BannerDTO(
            idx!!,
            bannerImg.toDTO(),
            detailImg.toDTO(),
            url,
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as MainBanner

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , bannerImg = $bannerImg , detailImg = $detailImg , url = $url , deleteYn = $deleteYn , createDate = $createDate , updateDate = $updateDate , deleteDate = $deleteDate )"
    }
}
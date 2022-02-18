package kr.co.point.common.entity.coupang.video

import kr.co.point.common.dto.coupang.response.CoupangVideoDTO
import kr.co.point.common.entity.file.File
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class CoupangVideo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @OneToOne(targetEntity = File::class)
    @JoinColumn(name = "thumbnail_idx", referencedColumnName = "idx")
    var thumbnail: File = File(),

    @OneToOne(targetEntity = File::class)
    @JoinColumn(name = "video_idx", referencedColumnName = "idx")
    var video: File = File(),

    @OneToOne(targetEntity = File::class)
    @JoinColumn(name = "photo_idx", referencedColumnName = "idx")
    var photo: File = File(),

    var url: String = "",
    var title: String = "",
    var price: Int = 0,
    var isRocket: Boolean = false,
    var isFreeShipping: Boolean = false,

    var showYn: String = "N",
    var deleteYn: String = "N",


    @CreationTimestamp
    var createDate: LocalDateTime? = null,

    @UpdateTimestamp
    var updateDate: LocalDateTime? = null,

    var deleteDate: LocalDateTime? = null,
) {

    fun toDTO() : CoupangVideoDTO {
        return CoupangVideoDTO(
            idx!!,
            photo.toDTO(),
            thumbnail.toDTO(),
            video.toDTO(),
            url,
            title,
            price,
            isRocket,
            isFreeShipping)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as CoupangVideo

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , thumbnail = $thumbnail , video = $video , photo = $photo , url = $url , title = $title , price = $price , isRocket = $isRocket , isFreeShipping = $isFreeShipping , showYn = $showYn , deleteYn = $deleteYn , createDate = $createDate , updateDate = $updateDate , deleteDate = $deleteDate )"
    }

}

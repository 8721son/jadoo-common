package kr.co.point.common.entity.coupang.product

import kr.co.point.common.dto.coupang.response.CoupangBannerDTO
import kr.co.point.common.entity.file.File
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class CoupangBanner(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @OneToOne(targetEntity = File::class)
    @JoinColumn(name = "photo_idx", referencedColumnName = "idx")
    var photo: File = File(),

    var url: String = "",

    var showYn: String = "N",
    var deleteYn: String = "N",


    @CreationTimestamp
    var createDate: LocalDateTime? = null,

    @UpdateTimestamp
    var updateDate: LocalDateTime? = null,

    var deleteDate: LocalDateTime? = null,
) {

    fun toDTO() : CoupangBannerDTO {
        return CoupangBannerDTO(idx!!, photo.toDTO(), url)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as CoupangBanner

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , photo = $photo , showYn = $showYn , deleteYn = $deleteYn , createDate = $createDate , updateDate = $updateDate , deleteDate = $deleteDate )"
    }
}

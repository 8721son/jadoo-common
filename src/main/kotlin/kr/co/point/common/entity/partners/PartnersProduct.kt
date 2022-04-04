package kr.co.point.common.entity.partners

import kr.co.point.common.dto.partners.response.MainProductDTO
import kr.co.point.common.dto.partners.response.PartnersProductDTO
import kr.co.point.common.dto.partners.response.PartnersProductDetailDTO
import kr.co.point.common.entity.file.File
import kr.co.point.common.util.dotNumberStrNormal
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class PartnersProduct(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @ManyToOne(targetEntity = Partners::class)
    @JoinColumn(name = "partners_idx", referencedColumnName = "idx")
    var partners : Partners = Partners(),

    var name : String = "",

    @OneToOne(targetEntity = File::class)
    @JoinColumn(name = "thumbnail_idx", referencedColumnName = "idx")
    var thumbnail : File = File(),

    var maxChangeDay : Int = 0,

    var showYn : String = "N",

    var price : Int = 0,
    var discountRate : Int = 0,

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updateDate : LocalDateTime? = null,
){
    fun toDetailDTO() : PartnersProductDetailDTO{
        val percent : Double = (100-discountRate)/100.0
        return PartnersProductDetailDTO(
            idx,
            partners.toDTO(),
            name,
            thumbnail.toDTO(),
            dotNumberStrNormal(price),
            dotNumberStrNormal(price * percent),
            discountRate,
            null,
            null,
            null,
            null
        )
    }

    fun toDTO() : PartnersProductDTO{
        return PartnersProductDTO(
            idx,
            partners.toDTO(),
            name,
            thumbnail.toDTO(),
            maxChangeDay,
            showYn,
            price,
            discountRate
        )
    }

    fun toMainProductDTO(isLike: Boolean) : MainProductDTO {
        val percent : Double = (100-discountRate)/100.0
        return MainProductDTO(
            idx!!,
            thumbnail.toDTO(),
            name,
            discountRate,
            dotNumberStrNormal(price * percent),
            isLike
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as PartnersProduct

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , partners = $partners , name = $name , thumbnail = $thumbnail , maxChangeDay = $maxChangeDay , showYn = $showYn , price = $price , discountRate = $discountRate , createDate = $createDate , updateDate = $updateDate )"
    }
}
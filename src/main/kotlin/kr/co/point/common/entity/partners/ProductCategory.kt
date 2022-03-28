package kr.co.point.common.entity.partners

import kr.co.point.common.dto.partners.response.PartnersSearchCategoryDTO
import kr.co.point.common.dto.partners.response.ProductCategoryDTO
import kr.co.point.common.entity.file.File
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class ProductCategory(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var code: Int? = null,

    @OneToOne(targetEntity = File::class)
    @JoinColumn(name = "icon_idx", referencedColumnName = "idx")
    var icon: File = File(),

    var name : String = "",

    var showYn: String = "N",

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updateDate : LocalDateTime? = null,


){
    fun toDTO() : ProductCategoryDTO{
        return ProductCategoryDTO(
            code!!,
            icon.toDTO(),
            name
        )
    }

    fun toSearchDTO() : PartnersSearchCategoryDTO{
        return PartnersSearchCategoryDTO(
            code!!,
            name,
            null
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as ProductCategory

        return code != null && code == other.code
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(code = $code , icon = $icon , name = $name , showYn = $showYn , createDate = $createDate , updateDate = $updateDate )"
    }
}
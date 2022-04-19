package kr.co.point.common.entity.partners

import kr.co.point.common.dto.partners.response.PartnersSearchCategoryDTO
import kr.co.point.common.dto.partners.response.PartnersSearchCategoryDetailDTO
import kr.co.point.common.entity.file.File
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class ProductCategoryDetail(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var code: Int? = null,

    var name : String = "",

    @ManyToOne(targetEntity = ProductCategory::class)
    @JoinColumn(name = "category_code", referencedColumnName = "code")
    var category : ProductCategory = ProductCategory(),

    @OneToOne(targetEntity = File::class)
    @JoinColumn(name = "icon_idx", referencedColumnName = "idx")
    var icon: File = File(),

    var showYn: String = "N",

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updateDate : LocalDateTime? = null,


    ){
    fun toSearchDTO() : PartnersSearchCategoryDTO{
        return PartnersSearchCategoryDTO(
            category.code!!,
            category.name,
            PartnersSearchCategoryDetailDTO(code!!,name)
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as ProductCategoryDetail

        return code != null && code == other.code
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(code = $code , name = $name , category = $category , showYn = $showYn , createDate = $createDate , updateDate = $updateDate )"
    }
}
package kr.co.point.common.entity.donation

import kr.co.point.common.dto.donation.v1.response.CampaignCategoryDTO
import kr.co.point.common.dto.donation.v1.response.CategoryDTO
import kr.co.point.common.dto.talent.response.TalentCategoryDTO
import kr.co.point.common.entity.file.File
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Category(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, insertable = false)
        var idx: Int? = null,

        var category: String = "",

        var useYn: String = "N",

        @OneToOne(targetEntity = File::class)
        @JoinColumn(name = "icon_idx", referencedColumnName = "idx")
        var icon : File = File(),

        @OneToMany(mappedBy = "category", cascade = [CascadeType.ALL], orphanRemoval = true)
        var tags : MutableList<CategoryTag> = ArrayList(),

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
) {
        fun toCategoryDTO() : CategoryDTO{
                return CategoryDTO(idx!!,category,icon.toDTO(),tags.stream().map { tag -> tag.toDTO() }.toList())
        }


        fun toCampaignCategoryDTO() : CampaignCategoryDTO{
                return CampaignCategoryDTO(idx!!,category,icon.toDTO())
        }

        fun toDTO() : TalentCategoryDTO{
                return TalentCategoryDTO(category)
        }

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as Category

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , category = $category , useYn = $useYn , createDate = $createDate , updateDate = $updateDate )"
        }

}
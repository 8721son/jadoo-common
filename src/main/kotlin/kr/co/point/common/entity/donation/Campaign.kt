package kr.co.point.common.entity.donation

import kr.co.point.common.dto.donation.v1.response.CampaignCurrentDTO
import kr.co.point.common.dto.donation.v1.response.CampaignDTO
import kr.co.point.common.dto.donation.v1.response.CampaignDetailDTO
import kr.co.point.common.dto.donation.v2.response.CampaignCurrentV2DTO
import kr.co.point.common.entity.file.File
import kr.co.point.common.enum_package.type.ContentType
import kr.co.point.common.enum_package.type.FoundationFileType
import kr.co.point.common.util.getLocalDateToString
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Campaign(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var idx: Int? = null,

        @OneToOne(targetEntity = File::class)
        @JoinColumn(name = "photo_idx", referencedColumnName = "idx")
        var photo: File = File(),

        var title: String = "",

        @ManyToOne(targetEntity = Foundation::class)
        @JoinColumn(name = "company_idx", referencedColumnName = "idx")
        var company: Foundation = Foundation(),

        @OneToOne(targetEntity = File::class)
        @JoinColumn(name = "detail_idx", referencedColumnName = "idx")
        var detail: File = File(),

        var introduce: String = "",
        var brix: Int = 0,
        var currentBrix: Int = 0,
        var startDate: LocalDateTime? = null,
        var endDate: LocalDateTime? = null,
        var content: String = "",

        var adminEndYn: String = "N",

        @ManyToOne(targetEntity = Category::class)
        @JoinColumn(name = "category_idx", referencedColumnName = "idx")
        var category: Category = Category(),

        @OneToMany(mappedBy = "campaign", cascade = [CascadeType.ALL], orphanRemoval = true)
        var campaignTags: MutableList<CampaignTag> = ArrayList(),

        @OneToMany(mappedBy = "campaign", cascade = [CascadeType.ALL], orphanRemoval = true)
        var campaignExecution: MutableList<CampaignExecution> = ArrayList(),

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,

        @Enumerated(EnumType.STRING)
        var contentType: ContentType = ContentType.IMAGE

) {

        fun toCampaignDetailDTO (like: Boolean) : CampaignDetailDTO {
                var end = ""
                if(endDate!!.isBefore(LocalDateTime.now())){
                        end = "Y"
                }

                if(adminEndYn=="Y"){
                        end="Y"
                }

                var mainFile = File()
                var detailFile = File()
                company.file!!.forEach { i->
                        if(i.type==FoundationFileType.MAIN){
                                mainFile=i.file
                        }
                        if(i.type==FoundationFileType.DETAIL){
                                detailFile=i.file
                        }
                }
                return CampaignDetailDTO(
                        idx!!,
                        photo.toDTO(),
                        title,
                        company.name,
                        detail.toDTO(),
                        introduce,
                        like,
                        getLocalDateToString(startDate!!),
                        getLocalDateToString(endDate!!),
                        mainFile.toDTO(),
                        detailFile.toDTO(),
                        brix,
                        currentBrix,
                        campaignTags.map { donationTag -> donationTag.tag.toTagDTO() },
                        null,
                        end,
                        campaignExecution.map { campaignExecution -> campaignExecution.toDTO() }
                )
        }

        fun toCampaignDTO(like: Boolean) : CampaignDTO {
                var end = ""
                if(endDate!!.isBefore(LocalDateTime.now())){
                        end = "Y"
                }

                if(adminEndYn=="Y"){
                        end="Y"
                }

                return CampaignDTO(
                        idx!!,
                        photo.toDTO(),
                        title,
                        company.name,
                        like,
                        getLocalDateToString(endDate!!),
                        brix,
                        currentBrix,
                        campaignTags.map { donationTag -> donationTag.tag.toTagDTO() },
                        end,
                        category.toCampaignCategoryDTO()
                )
        }

        fun toCurrentCampaignDTO() : CampaignCurrentDTO {
                var end = ""
                if(endDate!!.isBefore(LocalDateTime.now())){
                        end = "Y"
                }

                if(adminEndYn=="Y"){
                        end="Y"
                }

                return CampaignCurrentDTO(
                        idx!!,
                        photo.toDTO(),
                        title,
                        content,
                        getLocalDateToString(endDate!!),
                        brix,
                        currentBrix,
                        end,
                )
        }

        fun toCurrentCampaignV2DTO() : CampaignCurrentV2DTO {
            var end = ""
            if(endDate!!.isBefore(LocalDateTime.now())){
                end = "Y"
            }

            if(adminEndYn=="Y"){
                end="Y"
            }

            return CampaignCurrentV2DTO(
                idx!!,
                photo.toDTO(),
                title,
                content,
                getLocalDateToString(endDate!!),
                brix,
                currentBrix,
                end,
                company.name
            )
        }

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as Campaign

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , photo = $photo , title = $title , company = $company , detail = $detail , introduce = $introduce , brix = $brix , startDate = $startDate , endDate = $endDate , createDate = $createDate , updateDate = $updateDate , contentType = $contentType )"
        }
}

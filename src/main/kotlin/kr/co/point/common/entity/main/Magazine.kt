package kr.co.point.common.entity.main

import kr.co.point.common.dto.main.MagazineDTO
import kr.co.point.common.entity.file.File
import kr.co.point.common.enum_package.type.MagazineType
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Magazine(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @OneToOne(targetEntity = File::class)
    @JoinColumn(name = "title_img_idx", referencedColumnName = "idx")
    var titleImg: File = File(),

    var title : String = "",
    var content : String = "",

    @OneToOne(targetEntity = MagazineDetail::class)
    @JoinColumn(name = "detail_idx", referencedColumnName = "idx")
    var magazineDetail: MagazineDetail = MagazineDetail(),

//    @ManyToOne(targetEntity = Campaign::class)
//    @JoinColumn(name = "campaign_idx", referencedColumnName = "idx")
//    var campaign: Campaign? = null,
//
//    @ManyToOne(targetEntity = Foundation::class)
//    @JoinColumn(name = "foundation_idx", referencedColumnName = "idx")
//    var foundation: Foundation? = null,
//
//    @ManyToOne(targetEntity = PartnersProduct::class)
//    @JoinColumn(name = "product_idx", referencedColumnName = "idx")
//    var product: PartnersProduct? = null,
//
//    @ManyToOne(targetEntity = Partners::class)
//    @JoinColumn(name = "partners_idx", referencedColumnName = "idx")
//    var partners: Partners? = null,

    var showYn: String = "N",

//    @Enumerated(EnumType.STRING)
//    var type : MagazineType = MagazineType.CAMPAIGN,

    @CreationTimestamp
    var createDate: LocalDateTime? = null,

    @UpdateTimestamp
    var updateDate: LocalDateTime? = null,
){
    fun toDTO() : MagazineDTO{
        var brand :String? = null
        var type : MagazineType = MagazineType.CAMPAIGN
        var path : Int = 0
        var jwtYn : String = "N"
//        if(campaign!=null){
//            brand = campaign!!.company.name
//            type = MagazineType.CAMPAIGN
//            path = campaign!!.idx!!
//            jwtYn = "Y"
//        }else if(product!=null){
//            brand =product!!.partners.business_name
//            type = MagazineType.PRODUCT
//        }else if(foundation!=null){
//            type = MagazineType.FOUNDATION
//            path = foundation!!.idx!!
//        }else if(partners!=null){
//            type = MagazineType.PARTNERS
//        }

        return MagazineDTO(
            idx,
            titleImg.toDTO(),
            brand,
            title,
            content,
            showYn,
            type,
            jwtYn,
            path
        )
    }
}
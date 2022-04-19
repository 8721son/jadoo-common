package kr.co.point.common.dto.main

import kr.co.point.common.dto.donation.v1.response.CampaignDTO
import kr.co.point.common.dto.donation.v1.response.FoundationDetailDTO
import kr.co.point.common.dto.file.response.FileDTO
import kr.co.point.common.dto.partners.response.PartnersDTO
import kr.co.point.common.dto.partners.response.PartnersProductDTO
import kr.co.point.common.entity.file.File
import kr.co.point.common.enum_package.type.MagazineType

data class MagazineDTO(
    var idx: Int? = null,
    var titleImg: FileDTO = FileDTO(),
    var brand : String? = "",
    var title : String = "",
    var content : String = "",
    var showYn: String = "N",
    var type : MagazineType = MagazineType.CAMPAIGN,
    var jwtYn : String = "N",
    var pathVariable : Int? = 0,

    var detail : MagazineDetailDTO = MagazineDetailDTO()
)

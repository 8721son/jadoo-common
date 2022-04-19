package kr.co.point.common.dto.main

import kr.co.point.common.dto.donation.v1.response.CampaignDTO
import kr.co.point.common.dto.donation.v1.response.FoundationDetailDTO
import kr.co.point.common.dto.file.response.FileDTO
import kr.co.point.common.dto.partners.response.PartnersDTO
import kr.co.point.common.dto.partners.response.PartnersProductDTO
import kr.co.point.common.entity.file.File
import kr.co.point.common.enum_package.type.MagazineType

data class MagazineDetailDTO(
    var link : String = "",
    var contentUrl : String = "",
    )

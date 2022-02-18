package kr.co.point.common.dto.donation.response

import kr.co.point.common.dto.search.response.TagDTO

data class CampaignListDTO(
    var myTag: List<TagDTO> = ArrayList(),
    var idx: Int = 0,
    var photo: String = "",
    var title: String = "",
    var content: String = "",
    var endDate: String = "",
    var targetBrix: Int = 0,
    var currentBrix: Int = 0,
    var jadoo: List<CampaignDTO> = ArrayList(),
    var deadline: List<CampaignDTO> = ArrayList(),
    var like: List<CampaignDTO> = ArrayList(),
    var tag: List<CampaignDTO> = ArrayList(),
    var endYn : String = "N"
 )

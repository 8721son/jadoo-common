package kr.co.point.common.dto.donation.response

import kr.co.point.common.dto.file.response.FileDTO
import kr.co.point.common.dto.member.MemberDTO
import kr.co.point.common.dto.member.response.MyDTO
import kr.co.point.common.dto.search.response.TagDTO
import kr.co.point.common.entity.member.Member

data class CampaignDetailDTO(
    var idx: Int = 0,
    var photo: FileDTO = FileDTO(),
    var title: String = "",
    var sub: String = "",
    var detail: FileDTO = FileDTO(),
    var introduce: String = "",
    var isLike: Boolean = false,
    var startDate: String = "",
    var endDate: String = "",
    var foundation: FileDTO = FileDTO(),
    var foundationDetail: FileDTO = FileDTO(),
    var targetBrix: Int = 0,
    var currentBrix: Int = 0,
    var tags: List<TagDTO>,
    var contributor : List<MyDTO>? = null,
    var endYn : String = "N"
 )

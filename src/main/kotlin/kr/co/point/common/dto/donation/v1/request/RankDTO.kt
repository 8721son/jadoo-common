package kr.co.point.common.dto.donation.v1.request

import kr.co.point.common.dto.member.MemberDTO
import kr.co.point.common.dto.member.response.MyDTO

data class RankDTO(
    var member: MyDTO = MyDTO(),
    var total : Int = 0
 )

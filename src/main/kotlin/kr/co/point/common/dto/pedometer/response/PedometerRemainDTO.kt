package kr.co.point.common.dto.pedometer.response

import kr.co.point.common.dto.member.MemberDTO
import kr.co.point.common.entity.point.Point
import kr.co.point.common.enum_package.type.PointType

data class PedometerRemainDTO(
    var remain : Int = 0,
 )
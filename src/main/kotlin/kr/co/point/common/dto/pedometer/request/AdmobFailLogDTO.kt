package kr.co.point.common.dto.pedometer.request

import kr.co.point.common.dto.member.MemberDTO
import kr.co.point.common.entity.point.Point
import kr.co.point.common.enum_package.type.PointType

data class AdmobFailLogDTO(
    var os : String = "",
    var code : Int = 0,
    var domain : String = "",
    var message : String = "",
 )
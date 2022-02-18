package kr.co.point.common.dto.point

import kr.co.point.common.dto.member.MemberDTO
import kr.co.point.common.entity.point.Point
import kr.co.point.common.enum_package.type.PointType

data class PointDTO(
    var idx: Int = 0,
    var memberDTO: MemberDTO = MemberDTO(),
    var pointType: PointType = PointType.EXPECTATION,
    var description: String? = null,
    var point: Int = 0,
    var count: Int = 0,
 ) {
    fun toEntity(): Point {
        return Point()
    }
}

package kr.co.point.common.enum_package.type

import kr.co.point.common.enum_package.status.PointStatus

/**
 * <p>USE 사용현황
 * <p>ACCUMULATION 누적현황
 * <p>EXPECTATION 예상현황
 * <p>JOIN 회원가입 적립
 */
enum class PointType {
    USE,
    ACCUMULATION,
    EXPECTATION,
    JOIN,
}

fun getPointStatus(pointType: PointType): PointStatus {
    return when (pointType) {
        PointType.USE -> {
            PointStatus.MINUS
        }
        PointType.EXPECTATION -> {
            PointStatus.EXPECTATION
        }
        PointType.ACCUMULATION -> {
            PointStatus.PLUS
        }
        PointType.JOIN -> {
            PointStatus.PLUS
        }
    }
}
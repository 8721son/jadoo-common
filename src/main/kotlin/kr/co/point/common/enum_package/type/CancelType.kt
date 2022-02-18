package kr.co.point.common.enum_package.type

enum class CancelType(val cancelType: String) {
    MIND("단순 변심"),
    SCHEDULE("일정 문제"),
    PERSONAL("개인 사정"),
    ETC("기타")
}
package kr.co.point.common.enum_package.type

enum class ReportType(val cancelType: String) {
    IRRELEVANT("컨텐츠와 관련없는 게시물"),
    MONEY("금전 요구"),
    INAPPROPRIATE("부적절한 게시물"),
    ETC("기타")
}
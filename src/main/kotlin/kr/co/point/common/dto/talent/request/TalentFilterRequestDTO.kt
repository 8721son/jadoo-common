package kr.co.point.common.dto.talent.request

data class  TalentFilterRequestDTO(
    var recruitStartDate: String = "", // 최신 순 - 디펄트, 오래된 순
    var category: String = "",
    var onOff: String = "", // 온라인, 오프라인 default 전체
    var area: String? = "", // default 전체
    var sigungu: String? = "", // default 전체
 )

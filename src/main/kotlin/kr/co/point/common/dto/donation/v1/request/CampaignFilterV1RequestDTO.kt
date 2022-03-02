package kr.co.point.common.dto.donation.v1.request

data class CampaignFilterV1RequestDTO(
    var title: String = "",
    var option1: String = "", // 최신 순 - 디펄트, 오래된 순
    var option2: String = "", // 전체, 모금 예정, 모금 중, 모금 마감

     // 값 3개에 따라서 동적 쿼리
     // "" title contain
     // orderby startdate
     // start 기준으로 동적으로

     // 동적 쿼리
     // @Query native query
     // 순수 JPA로 만들어야 함

 )

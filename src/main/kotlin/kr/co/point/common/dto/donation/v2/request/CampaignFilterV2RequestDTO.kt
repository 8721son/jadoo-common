package kr.co.point.common.dto.donation.v2.request

import kr.co.point.common.dto.search.request.TagFilterRequestDTO

data class CampaignFilterV2RequestDTO(
    var category: Int = 0,
    var tags : List<TagFilterRequestDTO>? = ArrayList(),
    var start: String = "", // 최신 순 - 디펄트, 오래된 순
    var status: String = "", // 전체, 모금 예정, 모금 중, 모금 마감

     // 값 3개에 따라서 동적 쿼리
     // "" title contain
     // orderby startdate
     // start 기준으로 동적으로

     // 동적 쿼리
     // @Query native query
     // 순수 JPA로 만들어야 함

 )

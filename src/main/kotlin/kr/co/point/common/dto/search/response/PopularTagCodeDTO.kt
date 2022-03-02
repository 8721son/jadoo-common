package kr.co.point.common.dto.search.response

data class PopularTagCodeDTO(
    var idx : Int = 0,
    var title : String = "",
    var cnt : Int = 0,
 ){
    fun toTagDTO(): TagDTO {
        return TagDTO(idx, title);
    }
}

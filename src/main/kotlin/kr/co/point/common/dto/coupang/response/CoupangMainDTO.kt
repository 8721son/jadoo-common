package kr.co.point.common.dto.coupang.response

data class CoupangMainDTO(
    var idx: Int = 0,
    var banner: List<CoupangBannerDTO> = ArrayList(),
    var category: List<CoupangCategoryDTO> = ArrayList(),
    var product: List<CoupangProductDTO> = ArrayList(),
    var goldbox: List<CoupangProductDTO> = ArrayList(),
 )

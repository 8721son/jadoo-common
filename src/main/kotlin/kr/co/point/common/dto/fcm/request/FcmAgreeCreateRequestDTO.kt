package kr.co.point.common.dto.fcm.request

data class FcmAgreeCreateRequestDTO(
    var arlim: Boolean = false,
    var marketing: Boolean = false,
    var night: Boolean = false,
 ) {
    fun getArlimYn() : String {
        return if (arlim) {
            "Y"
        } else {
            "N"
        }
    }

    fun getMarketingYn() : String {
        return if (marketing) {
            "Y"
        } else {
            "N"
        }
    }

    fun getNightYn() : String {
        return if (night) {
            "Y"
        } else {
            "N"
        }
    }
}

package kr.co.point.common.dto.nice.response

import kr.co.point.common.dto.file.response.FileDTO

data class CryptoBodyDTO(
    var rsp_cd : String = "",
    var res_msg : String = "",
    var result_cd : Long = 0,
    var site_code : String = "",
    var token_version_id : String = "",
    var token_val : String = "",
    var period : String = "",
)

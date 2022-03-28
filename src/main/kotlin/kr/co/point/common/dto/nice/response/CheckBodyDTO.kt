package kr.co.point.common.dto.nice.response

import kr.co.point.common.dto.file.response.FileDTO

data class CheckBodyDTO(
    var rsp_cd : String = "",
    var res_msg : String = "",
    var result_cd : Long = 0,
)

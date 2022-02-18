package kr.co.point.common.dto.qna.response

import kr.co.point.common.dto.file.response.FileDTO

data class QnaDetailDTO(
    var idx: Int = 0,
    var qTitle: String = "",
    var qCreateAt: String = "",
    var qContent: String = "",
    var qFile: FileDTO? = null,
    var aTitle: String? = null,
    var aCreateAt: String? = null,
    var aContent: String? = null,
    var aFile: FileDTO? = null,
 )

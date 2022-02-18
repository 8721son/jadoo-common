package kr.co.point.common.dto.qna.request

import kr.co.point.common.dto.file.response.FileDTO

data class QnaRequestDTO(
    var email: String? = "",
    var title: String = "",
    var content: String = "",
    var file: FileDTO? = null,
 )

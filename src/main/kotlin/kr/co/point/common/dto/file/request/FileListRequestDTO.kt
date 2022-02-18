package kr.co.point.common.dto.file.request

import kr.co.point.common.enum_package.type.FileType

data class FileListRequestDTO(
    var idx: Long? = null,
    var originalName: String,
    var extension: String,
    var url: String,
    var deleteYn: String
)

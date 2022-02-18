package kr.co.point.common.dto.file.request

import kr.co.point.common.enum_package.type.FileType

data class FileRequestDTO(
    var idx: Int? = null,
    var fileCategory: FileType,
    var files: List<FileListRequestDTO>
)

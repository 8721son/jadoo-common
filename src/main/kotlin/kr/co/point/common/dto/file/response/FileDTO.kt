package kr.co.point.common.dto.file.response

import kr.co.point.common.entity.file.File
import kr.co.point.common.entity.file.FileDetail
import kr.co.point.common.enum_package.type.FileType

data class FileDTO(
    var idx: Int = 0,
    var fileCategory: FileType? = null,
    var files: List<FileDetailDTO> = ArrayList(),
) {
    fun toEntity() : File {
        return File(idx, files.map(FileDetailDTO::toEntity) as MutableList<FileDetail>, fileCategory)
    }
}

package kr.co.point.common.dto.donation.v1.response

import kr.co.point.common.dto.file.response.FileDetailDTO
import kr.co.point.common.enum_package.type.FileType

data class FoundationFileDTO(
    var idx: Int = 0,
    var url: String? = null,
    var fileCategory: FileType? = null,
    var files: List<FileDetailDTO> = ArrayList(),
    )

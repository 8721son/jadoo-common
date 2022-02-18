package kr.co.point.common.dto.donation.response

import kr.co.point.common.dto.file.response.FileDTO
import kr.co.point.common.dto.file.response.FileDetailDTO
import kr.co.point.common.dto.search.response.TagDTO
import kr.co.point.common.enum_package.type.FileType
import kr.co.point.common.enum_package.type.FoundationFileType

data class FoundationFileDTO(
    var idx: Int = 0,
    var url: String? = null,
    var fileCategory: FileType? = null,
    var files: List<FileDetailDTO> = ArrayList(),
    )

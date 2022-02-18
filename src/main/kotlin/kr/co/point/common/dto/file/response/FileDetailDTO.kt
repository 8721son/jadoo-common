package kr.co.point.common.dto.file.response

import kr.co.point.common.entity.file.FileDetail
import java.time.LocalDateTime

data class FileDetailDTO(
    var idx: Int? = 0,
    var fileIdx: Int = 0,
    var originalName: String,
    var extension: String,
    var size: Long = 0,
    var fileUrl: String,
    var createDate: LocalDateTime,
) {
    fun toEntity() : FileDetail {
        return FileDetail(
            idx, fileIdx, originalName,
            extension, size, fileUrl, createDate
        )
    }
}

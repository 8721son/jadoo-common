package kr.co.point.common.repository.file

import kr.co.point.common.entity.file.FileDetail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FileDetailRepository : JpaRepository<FileDetail, Int>
package kr.co.point.common.repository.file

import kr.co.point.common.entity.file.File
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FileRepository : JpaRepository<File, Int>
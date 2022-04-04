package kr.co.point.common.repository.notice

import kr.co.point.common.entity.notice.Notice
import org.springframework.data.jpa.repository.JpaRepository

interface NoticeRepository : JpaRepository<Notice, Int>{
}
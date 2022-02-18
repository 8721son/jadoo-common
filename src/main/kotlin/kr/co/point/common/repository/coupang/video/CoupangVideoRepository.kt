package kr.co.point.common.repository.coupang.video

import kr.co.point.common.entity.coupang.video.CoupangVideo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CoupangVideoRepository : JpaRepository<CoupangVideo, Int> {
    fun findByDeleteYnAndShowYn(pageable: Pageable, deleteYn: String, showYn: String): Page<CoupangVideo>
    fun findTopByDeleteYnAndShowYnOrderByCreateDateDesc(deleteYn: String, showYn: String): Optional<CoupangVideo>
}
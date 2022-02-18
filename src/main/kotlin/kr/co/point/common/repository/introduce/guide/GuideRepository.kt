package kr.co.point.common.repository.introduce.guide

import kr.co.point.common.entity.introduce.Guide
import kr.co.point.common.entity.introduce.Terms
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface GuideRepository : JpaRepository<Guide, Int>{
    fun findTopByDeleteYnOrderBySortAsc(delete_yn : String) : Optional<Guide>
}
package kr.co.point.common.repository.pedometer

import kr.co.point.common.entity.pedometer.AdmobLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AdmobLogRepository : JpaRepository<AdmobLog, Int> {
    fun findByMember_IdxAndCustomData(member_idx : Int, custom_data : String) : Optional<AdmobLog>
}
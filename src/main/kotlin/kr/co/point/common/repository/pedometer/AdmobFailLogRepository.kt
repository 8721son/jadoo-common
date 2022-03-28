package kr.co.point.common.repository.pedometer

import kr.co.point.common.entity.pedometer.AdmobFailLog
import kr.co.point.common.entity.pedometer.AdmobLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AdmobFailLogRepository : JpaRepository<AdmobFailLog, Int> {
}
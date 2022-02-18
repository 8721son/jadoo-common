package kr.co.point.common.repository.bootpay

import kr.co.point.common.entity.bootpay.BootpayFailLog
import kr.co.point.common.entity.bootpay.BootpayLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BootpayFailLogRepository: JpaRepository<BootpayFailLog, Int> {
}
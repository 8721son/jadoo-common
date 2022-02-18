package kr.co.point.common.repository.bootpay

import kr.co.point.common.entity.bootpay.BootpayLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BootpayLogRepository: JpaRepository<BootpayLog, Int> {
    fun findTopByOrderId(order_id: String): Optional<BootpayLog>;
    fun findByMember_EmailAndStatus(email: String, status: String) : List<BootpayLog>
}
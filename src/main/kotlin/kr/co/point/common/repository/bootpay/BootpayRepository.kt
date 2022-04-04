package kr.co.point.common.repository.bootpay

import kr.co.point.common.entity.bootpay.Bootpay
import kr.co.point.common.entity.bootpay.BootpayLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface BootpayRepository : JpaRepository<Bootpay, Int> {
    fun findByOrderId(order_id: String): Optional<Bootpay>;
    fun findByMember_EmailAndStatus(email: String, status: String) : List<Bootpay>
}
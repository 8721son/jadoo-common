package kr.co.point.common.repository.coupang.product

import kr.co.point.common.entity.coupang.product.CoupangSearchLimit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface CoupangSearchLimitRepository : JpaRepository<CoupangSearchLimit, Int> {
    fun deleteByDateTimeBefore(dateTime: LocalDateTime)
}
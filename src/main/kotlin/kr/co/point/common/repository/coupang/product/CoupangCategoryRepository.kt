package kr.co.point.common.repository.coupang.product

import kr.co.point.common.entity.coupang.product.CoupangCategory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CoupangCategoryRepository : JpaRepository<CoupangCategory, Int> {
    fun findByDeleteYnAndShowYn(deleteYn: String, showYn: String): List<CoupangCategory>
    fun findByDeleteYnAndShowYnAndIdx(deleteYn: String, showYn: String, idx: Int): Optional<CoupangCategory>
}
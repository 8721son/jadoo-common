package kr.co.point.common.repository.coupang.product

import kr.co.point.common.entity.coupang.product.CoupangBanner
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CoupangBannerRepository : JpaRepository<CoupangBanner, Int> {
    fun findByDeleteYnAndShowYn(deleteYn: String, showYn: String): List<CoupangBanner>
}
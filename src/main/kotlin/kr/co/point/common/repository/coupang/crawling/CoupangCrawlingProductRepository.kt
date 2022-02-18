package kr.co.point.common.repository.coupang.crawling

import kr.co.point.common.entity.coupang.crawling.CoupangCrawlingProduct
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CoupangCrawlingProductRepository : JpaRepository<CoupangCrawlingProduct, Int>
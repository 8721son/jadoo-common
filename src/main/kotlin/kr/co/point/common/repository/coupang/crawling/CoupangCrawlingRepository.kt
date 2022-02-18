package kr.co.point.common.repository.coupang.crawling

import kr.co.point.common.entity.coupang.crawling.CoupangCrawling
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CoupangCrawlingRepository : JpaRepository<CoupangCrawling, Int>
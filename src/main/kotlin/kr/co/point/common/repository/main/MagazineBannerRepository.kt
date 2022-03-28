package kr.co.point.common.repository.main

import kr.co.point.common.entity.main.MagazineBanner
import kr.co.point.common.entity.main.MainBanner
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MagazineBannerRepository : JpaRepository<MagazineBanner, Int> {
    fun findByDeleteYnAndShowYn(deleteYn: String, showYn: String): List<MagazineBanner>
}
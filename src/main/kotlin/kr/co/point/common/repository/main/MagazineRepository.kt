package kr.co.point.common.repository.main

import kr.co.point.common.entity.main.Magazine
import kr.co.point.common.entity.main.MainBanner
import kr.co.point.common.enum_package.type.MagazineType
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MagazineRepository : JpaRepository<Magazine, Int> {
    fun findByType(type : MagazineType,pageable: Pageable) : Page<Magazine>
}
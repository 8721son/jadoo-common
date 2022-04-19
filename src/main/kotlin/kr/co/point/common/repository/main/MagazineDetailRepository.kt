package kr.co.point.common.repository.main

import kr.co.point.common.entity.main.MagazineDetail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MagazineDetailRepository : JpaRepository<MagazineDetail, Int>
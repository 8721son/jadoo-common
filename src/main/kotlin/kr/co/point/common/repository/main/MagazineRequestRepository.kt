package kr.co.point.common.repository.main

import kr.co.point.common.entity.main.MagazineRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MagazineRequestRepository : JpaRepository<MagazineRequest, Int>
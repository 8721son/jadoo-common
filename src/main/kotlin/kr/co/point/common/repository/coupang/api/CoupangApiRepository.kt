package kr.co.point.common.repository.coupang.api

import kr.co.point.common.entity.coupang.api.CoupangApi
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CoupangApiRepository : JpaRepository<CoupangApi, Int>
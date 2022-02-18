package kr.co.point.common.repository.coupang.api

import kr.co.point.common.entity.coupang.api.CoupangApiCancel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CoupangApiCancelRepository : JpaRepository<CoupangApiCancel, Int>
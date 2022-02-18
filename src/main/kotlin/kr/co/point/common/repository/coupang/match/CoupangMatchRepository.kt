package kr.co.point.common.repository.coupang.match

import kr.co.point.common.entity.coupang.match.CoupangMatch
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CoupangMatchRepository : JpaRepository<CoupangMatch, Int>
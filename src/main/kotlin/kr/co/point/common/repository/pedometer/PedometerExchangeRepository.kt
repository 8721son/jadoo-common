package kr.co.point.common.repository.pedometer

import kr.co.point.common.entity.pedometer.AdmobLog
import kr.co.point.common.entity.pedometer.PedometerExchange
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PedometerExchangeRepository : JpaRepository<PedometerExchange, Int> {
    fun findByMember_Idx(member_idx : Int) : List<PedometerExchange>
}
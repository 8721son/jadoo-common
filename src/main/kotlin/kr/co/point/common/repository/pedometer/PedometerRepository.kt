package kr.co.point.common.repository.pedometer

import kr.co.point.common.entity.pedometer.AdmobLog
import kr.co.point.common.entity.pedometer.Pedometer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PedometerRepository : JpaRepository<Pedometer, Int> {
    fun findByMember_Idx(idx : Int) : Optional<Pedometer>
}
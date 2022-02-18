package kr.co.point.common.repository.talent

import kr.co.point.common.entity.talent.TalentAttendance
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TalentAttendanceRepository : JpaRepository<TalentAttendance, Int> {
    fun deleteByMember_EmailAndTalentIdx(email: String, talent_idx:Int)
}
package kr.co.point.common.repository.talent

import kr.co.point.common.entity.talent.Talent
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TalentRepository : JpaRepository<Talent, Int> {
    fun findByIdx(idx : Int) : Optional<Talent>
    fun findByIdxAndOrganizer_Email(idx : Int,email: String) : Optional<Talent>
}
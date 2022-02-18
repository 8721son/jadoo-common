package kr.co.point.common.repository.donation

import kr.co.point.common.entity.donation.Foundation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FoundationRepository : JpaRepository<Foundation, Int>{
    fun findByIdx(idx : Int) : Optional<Foundation>
}
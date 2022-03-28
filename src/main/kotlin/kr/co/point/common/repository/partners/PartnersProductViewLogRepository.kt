package kr.co.point.common.repository.partners

import kr.co.point.common.entity.partners.PartnersProductViewLog
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PartnersProductViewLogRepository : JpaRepository<PartnersProductViewLog, Int> {
    fun findByMember_IdxOrderByCreateDateDesc(member_idx:Int) : List<PartnersProductViewLog>
    fun findDistinctByMember_IdxOrderByCreateDateDesc(member_idx:Int,pageable: Pageable) : Page<PartnersProductViewLog>
}
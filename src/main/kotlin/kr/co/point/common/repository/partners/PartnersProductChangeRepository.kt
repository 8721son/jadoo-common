package kr.co.point.common.repository.partners

import kr.co.point.common.entity.partners.Partners
import kr.co.point.common.entity.partners.PartnersProductChange
import kr.co.point.common.entity.pedometer.AdmobFailLog
import kr.co.point.common.entity.pedometer.AdmobLog
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PartnersProductChangeRepository : JpaRepository<PartnersProductChange, Int> {
    fun findByMember_IdxOrderByCreateDateDesc(member_idx:Int,pageable: Pageable) : Page<PartnersProductChange>
}
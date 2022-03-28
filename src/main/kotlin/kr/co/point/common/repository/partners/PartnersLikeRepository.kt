package kr.co.point.common.repository.partners

import kr.co.point.common.entity.partners.Partners
import kr.co.point.common.entity.partners.PartnersBank
import kr.co.point.common.entity.partners.PartnersLike
import kr.co.point.common.entity.pedometer.AdmobFailLog
import kr.co.point.common.entity.pedometer.AdmobLog
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PartnersLikeRepository : JpaRepository<PartnersLike, Int> {
    fun deleteByMember_IdxAndPartners_Idx(member_idx:Int,partners_idx:Int)
    fun findByMember_Idx(member_idx: Int,pageable: Pageable) : Page<PartnersLike>
    fun findByMember_IdxOrderByCreateDateDesc(member_idx: Int) : List<PartnersLike>
}
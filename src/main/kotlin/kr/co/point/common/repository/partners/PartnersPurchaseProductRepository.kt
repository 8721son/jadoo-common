package kr.co.point.common.repository.partners

import kr.co.point.common.entity.partners.Partners
import kr.co.point.common.entity.partners.PartnersPurchaseProduct
import kr.co.point.common.entity.pedometer.AdmobFailLog
import kr.co.point.common.entity.pedometer.AdmobLog
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PartnersPurchaseProductRepository : JpaRepository<PartnersPurchaseProduct, Int> {
    fun findByMember_IdxOrderByCreateDateDesc(member_idx : Integer,pageable : Pageable) : Page<PartnersPurchaseProduct>
    fun findByOrderNumber(orderNumber : String) : Optional<PartnersPurchaseProduct>
    fun findByIdx(idx:Int) : Optional<PartnersPurchaseProduct>
}
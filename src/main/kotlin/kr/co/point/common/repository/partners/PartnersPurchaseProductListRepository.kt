package kr.co.point.common.repository.partners

import kr.co.point.common.entity.partners.Partners
import kr.co.point.common.entity.partners.PartnersPurchaseProductList
import kr.co.point.common.entity.pedometer.AdmobFailLog
import kr.co.point.common.entity.pedometer.AdmobLog
import kr.co.point.common.enum_package.status.PurchaseStatus
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PartnersPurchaseProductListRepository : JpaRepository<PartnersPurchaseProductList, Int> {
    fun findByPurchase_Member_Idx(member_idx:Int,pageable: Pageable) : Page<PartnersPurchaseProductList>
    fun findByPurchase_Member_IdxAndStatus(member_idx:Int, status : PurchaseStatus, pageable: Pageable) : Page<PartnersPurchaseProductList>
    fun findAllByPurchase_Member_Idx(member_idx:Int) : List<PartnersPurchaseProductList>
    fun findByIdx(idx : Int) : Optional<PartnersPurchaseProductList>
}
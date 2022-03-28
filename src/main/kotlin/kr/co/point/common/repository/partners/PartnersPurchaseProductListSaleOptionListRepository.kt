package kr.co.point.common.repository.partners

import kr.co.point.common.entity.partners.Partners
import kr.co.point.common.entity.partners.PartnersPurchaseProductListSaleOptionList
import kr.co.point.common.entity.pedometer.AdmobFailLog
import kr.co.point.common.entity.pedometer.AdmobLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PartnersPurchaseProductListSaleOptionListRepository : JpaRepository<PartnersPurchaseProductListSaleOptionList, Int> {
    fun findByPurchaseProductListSaleOption_PurchaseProductList_Idx(product_idx: Int) : List<PartnersPurchaseProductListSaleOptionList>
}
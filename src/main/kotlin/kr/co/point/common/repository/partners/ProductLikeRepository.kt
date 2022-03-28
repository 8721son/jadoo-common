package kr.co.point.common.repository.partners

import kr.co.point.common.entity.partners.Partners
import kr.co.point.common.entity.partners.PartnersBank
import kr.co.point.common.entity.partners.PartnersLike
import kr.co.point.common.entity.partners.ProductLike
import kr.co.point.common.entity.pedometer.AdmobFailLog
import kr.co.point.common.entity.pedometer.AdmobLog
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductLikeRepository : JpaRepository<ProductLike, Int> {
    fun findByProduct_IdxIn(idx : List<Int>) : List<ProductLike>
    fun findByMember_IdxOrderByCreateDateDesc(member_idx : Int) : List<ProductLike>
    fun findByMember_IdxOrderByCreateDateDesc(member_idx : Int,pageable: Pageable) : Page<ProductLike>
    fun deleteByMember_IdxAndProduct_Idx(member_idx: Int,product_idx:Int)

}
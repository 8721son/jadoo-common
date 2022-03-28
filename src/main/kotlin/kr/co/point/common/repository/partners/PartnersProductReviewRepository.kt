package kr.co.point.common.repository.partners

import kr.co.point.common.entity.partners.Partners
import kr.co.point.common.entity.partners.PartnersProductReview
import kr.co.point.common.entity.pedometer.AdmobFailLog
import kr.co.point.common.entity.pedometer.AdmobLog
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PartnersProductReviewRepository : JpaRepository<PartnersProductReview, Int> {
    fun findByMember_idxAndPurchase_Idx(member_idx : Int, product_idx : Int) : Optional<PartnersProductReview>
    fun findByPurchase_Product_IdxAndDeleteYn(product_idx: Int,pageable : Pageable,deleteYn: String) : Page<PartnersProductReview>
    fun findByMember_idxAndDeleteYn(member_idx: Int,deleteYn: String,pageable: Pageable) : Page<PartnersProductReview>
    fun findByIdxAndDeleteYn(review_idx: Int,deleteYn : String) : Optional<PartnersProductReview>
}
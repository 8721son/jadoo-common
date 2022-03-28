package kr.co.point.common.repository.partners

import kr.co.point.common.entity.partners.Partners
import kr.co.point.common.entity.partners.PartnersCategory
import kr.co.point.common.entity.pedometer.AdmobFailLog
import kr.co.point.common.entity.pedometer.AdmobLog
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PartnersCategoryRepository : JpaRepository<PartnersCategory, Int> {
    fun findByCategoryDetail_Category_Code(code : Int) : List<PartnersCategory>
    fun findByCategoryDetail_Category_Code(code : Int,pageable: Pageable) : Page<PartnersCategory>
    fun findByCategoryDetail_Code(code : Int) : List<PartnersCategory>
    fun findByCategoryDetail_Code(code : Int,pageable: Pageable) : Page<PartnersCategory>
}
package kr.co.point.common.repository.partners

import kr.co.point.common.entity.partners.Partners
import kr.co.point.common.entity.partners.ProductCategory
import kr.co.point.common.entity.partners.ProductCategoryDetail
import kr.co.point.common.entity.pedometer.AdmobFailLog
import kr.co.point.common.entity.pedometer.AdmobLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductCategoryDetailRepository : JpaRepository<ProductCategoryDetail, Int> {
    fun findByShowYn(show_yn : String) : List<ProductCategoryDetail>
    fun findByShowYnAndNameContaining(show_yn : String,name : String) : List<ProductCategoryDetail>
}
package kr.co.point.common.repository.partners

import kr.co.point.common.entity.partners.Partners
import kr.co.point.common.entity.partners.PartnersProduct
import kr.co.point.common.entity.pedometer.AdmobFailLog
import kr.co.point.common.entity.pedometer.AdmobLog
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PartnersProductRepository : JpaRepository<PartnersProduct, Int> {
    fun findByIdx(idx : Int) : Optional<PartnersProduct>
    fun findByIdxIn(idx : List<Int>) : List<PartnersProduct>
    fun findByPartners_Idx(idx : Int) : List<PartnersProduct>
    fun findByPartners_Idx(idx : Int,pageable: Pageable) : Page<PartnersProduct>
    fun findByNameContaining(name : String) : List<PartnersProduct>
    fun findByNameContaining(name : String,pageable: Pageable) : Page<PartnersProduct>
}
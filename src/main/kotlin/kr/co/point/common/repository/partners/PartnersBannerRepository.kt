package kr.co.point.common.repository.partners

import kr.co.point.common.entity.partners.Partners
import kr.co.point.common.entity.partners.PartnersBank
import kr.co.point.common.entity.partners.PartnersBanner
import kr.co.point.common.entity.pedometer.AdmobFailLog
import kr.co.point.common.entity.pedometer.AdmobLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PartnersBannerRepository : JpaRepository<PartnersBanner, Int> {
    fun findByShowYn(show_yn:String) : List<PartnersBanner>
}
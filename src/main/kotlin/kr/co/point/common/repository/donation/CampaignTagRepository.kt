package kr.co.point.common.repository.donation

import kr.co.point.common.entity.donation.CampaignTag
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CampaignTagRepository : JpaRepository<CampaignTag, Int> {
    fun findByTagIdxIn(tag_idx: List<Int>) : List<CampaignTag>
    fun findByCampaignCompanyIdx(company_idx: Int) : List<CampaignTag>
}
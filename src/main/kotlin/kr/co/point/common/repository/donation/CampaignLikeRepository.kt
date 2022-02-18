package kr.co.point.common.repository.donation

import kr.co.point.common.entity.donation.CampaignLike
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CampaignLikeRepository : JpaRepository<CampaignLike, Int> {
    fun findTob1ByMemberEmail(member_email: String): List<CampaignLike>
    fun findByMemberEmail(member_email: String, pageable: Pageable): Page<CampaignLike>
    fun findByCampaignIdx(donation_idx: Int): List<CampaignLike>
    fun findByCampaignIdxIn(donation_idx: List<Int>): List<CampaignLike>
    fun deleteByCampaignIdxAndMemberIdx(donation_idx: Int, member_idx: Int)
    fun findByCampaignIdxAndMemberIdx(donation_idx: Int, member_idx: Int): Optional<CampaignLike>
}
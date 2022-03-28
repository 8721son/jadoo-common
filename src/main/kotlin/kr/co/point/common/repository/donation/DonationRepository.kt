package kr.co.point.common.repository.donation

import kr.co.point.common.dto.donation.v1.request.RankDTO
import kr.co.point.common.entity.donation.Donation
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface DonationRepository : JpaRepository<Donation, Int>{
    fun findByCampaign_Idx(campaign_idx : Int) : List<Donation>
    fun findByMember_Idx(member_idx : Int,pageable: Pageable) : Page<Donation>
}
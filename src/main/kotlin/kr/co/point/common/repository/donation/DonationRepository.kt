package kr.co.point.common.repository.donation

import kr.co.point.common.entity.donation.Donation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DonationRepository : JpaRepository<Donation, Int>{
    fun findByCampaign_Idx(campaign_idx : Int) : List<Donation>
}
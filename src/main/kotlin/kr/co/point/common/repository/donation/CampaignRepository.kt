package kr.co.point.common.repository.donation

import kr.co.point.common.entity.donation.Campaign
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface CampaignRepository : JpaRepository<Campaign, Int> {
    fun findTop3By(): List<Campaign>
    fun findTop10ByEndDateGreaterThanEqual(endDate: LocalDateTime): List<Campaign>
    fun findByEndDateGreaterThanEqual(endDate: LocalDateTime, pageable: Pageable): Page<Campaign>
    fun findByEndDateGreaterThanEqualAndIdxIn(endDate: LocalDateTime, pageable: Pageable, idxList: List<Int>): Page<Campaign>
    fun findByEndDateLessThanEqualAndEndDateGreaterThanEqual(pageable: Pageable, startDate: LocalDateTime, endDate: LocalDateTime): Page<Campaign>

    fun findByCompany_Idx(company_idx : Int,pageable: Pageable) : Page<Campaign>

    @Query(value = "select sum(d.currentBrix) from Campaign d")
    fun currentBrixSum(): Long

}
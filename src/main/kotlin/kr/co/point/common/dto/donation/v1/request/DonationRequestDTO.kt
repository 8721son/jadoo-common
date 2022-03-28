package kr.co.point.common.dto.donation.v1.request

import javax.validation.constraints.NotNull

data class DonationRequestDTO(
    @field:NotNull
    var campaignIdx: Int = 0,
    @field:NotNull
    var brix: Int = 0,
 )

package kr.co.point.common.dto.partners.request

import kr.co.point.common.entity.file.File
import kr.co.point.common.enum_package.status.MemberStatus
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class PartnerInsertDTO(

    @field:NotEmpty(message = "비밀번호를 입력해주세요.")
    var password : String = "",

    @field:NotEmpty(message = "휴대폰 번호를 입력해주세요.")
    var hp : String = "",

    @field:NotEmpty(message = "사업자명을 입력해주세요.")
    var business_name : String = "",

    var companyRegistrationNumber : Int = 0,

    @field:NotNull(message = "로고가 없습니다.")
    var logoImg : File? = null,
    var mainImg : File? = null,
    var description : String? = null,
    var status : MemberStatus = MemberStatus.NORMAL,
)

package kr.co.point.common.dto.member

import kr.co.point.common.dto.file.response.FileDTO
import kr.co.point.common.entity.member.Member
import kr.co.point.common.enum_package.status.MemberStatus
import kr.co.point.common.enum_package.type.RoleType
import java.time.LocalDateTime

data class MemberDTO (
    var idx: Int = 0,
    var id: String = "",
    var username: String = "",
    var nickname: String = "",
    var birth: String = "",
    var password: String = "",
    var email: String = "",
    var hp: String = "",
    var totalPoint: Int = 0,
    var status: MemberStatus = MemberStatus.NORMAL,
    var role: RoleType = RoleType.MEMBER,
    var createDate: LocalDateTime? = null,
    var updateDate: LocalDateTime? = null,
    var loginDate: LocalDateTime? = null,
    var iamportUid: String = "",
    var profileImg: FileDTO? = null,
    var oauthGoogle: String = "",
    var oauthKakao: String = "",
    var oauthApple: String = "",
) {
    fun toEntity() : Member {
        return Member()
    }
}

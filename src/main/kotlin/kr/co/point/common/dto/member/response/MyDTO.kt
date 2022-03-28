package kr.co.point.common.dto.member.response

import kr.co.point.common.dto.file.response.FileDTO
import kr.co.point.common.dto.friend.reponse.AboutFriendDTO
import kr.co.point.common.dto.friend.reponse.CommonInfoFriendDTO

data class MyDTO(
    var idx: Int = 0,
    var nickname: String = "",

    var profileImg: FileDTO? = FileDTO(),
    var brix: Int = 0,
    var birth: String = "",
    var friends: CommonInfoFriendDTO? = CommonInfoFriendDTO(),
    )

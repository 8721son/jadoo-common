package kr.co.point.common.dto.fcm.request

import kr.co.point.common.enum_package.type.OSType

data class FcmCreateRequestDTO(
    var token: String = "",
    var ssaid: String = "",
    var os: OSType = OSType.A,
    var agreeYn: String = "N",
 )

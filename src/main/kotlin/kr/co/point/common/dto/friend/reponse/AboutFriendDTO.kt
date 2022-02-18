package kr.co.point.common.dto.friend.reponse

import kr.co.point.common.dto.file.response.FileDTO


data class AboutFriendDTO(
    var idx: Int = 0,
    var name: String = "",
    var nameKor: String = "",
    var color: String = "",
    var graBegin: String = "",
    var graEnd: String = "",
    var content: String = "",
    var summary: String = "",
    var title: String = "",
    var brixImg: FileDTO = FileDTO(),
    var icon: FileDTO = FileDTO(),
    var iconWave: FileDTO = FileDTO(),
    var iconDisable: FileDTO = FileDTO(),
    var iconEnable: FileDTO = FileDTO(),
    var iconFull: FileDTO = FileDTO(),
    var brix: Int = 0,
    var canSelectYn : String = "N",
)

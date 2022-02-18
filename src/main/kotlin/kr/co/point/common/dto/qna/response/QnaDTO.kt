package kr.co.point.common.dto.qna.response

data class QnaDTO(
    var idx: Int = 0,
    var title: String = "",
    var createAt: String = "",
    var content: String = "",
    var answerYn: Boolean = false,
 )

package kr.co.point.common.dto.talent.response

import kr.co.point.common.entity.talent.Talent
import kr.co.point.common.entity.talent.TalentReply
import java.time.LocalDateTime

data class TalentCommentDTO (
    var idx: Int? = null,
    var comment: String = "",
    var talent: Talent? = null,
    var reply: MutableList<TalentReply> = ArrayList(),
    var createDate: LocalDateTime = LocalDateTime.now(),
)
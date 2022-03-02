  package kr.co.point.common.dto.talent.response

import kr.co.point.common.entity.donation.Category
import kr.co.point.common.entity.file.File
import kr.co.point.common.entity.member.Member
import kr.co.point.common.entity.talent.*
import java.time.LocalDateTime

  data class TalentDetailDTO (
      var idx: Int? = null,
      var organizer: Member = Member(),
      var title: String = "",

      var recruitStartDate : LocalDateTime? = null,
      var recruitEndDate : LocalDateTime? = null,

      var startDate : LocalDateTime? = null,
      var endDate : LocalDateTime? = null,
      var startTime : String = "",
      var endTime : String = "",

      var onlineYn : String ? = "N",

      var url: String? = "",

      var address: String? = "",
      var detailAddress: String? = "",

      var longitude: Double? = 0.0,
      var latitude: Double? = 0.0,

      var totalRecruit: Int = 0,

      var description : String = "",

      var cancelYn: String = "N",
      var cancelReason: String? = "",

      var type: String? = "",

      var category: Category? = null,

      var notice: MutableList<TalentNotice>? = null,

      var comments: MutableList<TalentComment>? = null,

      var tag: MutableList<TalentTag>? = null,

      var participant: MutableList<TalentAttendance>? = null,

      var file: File? = null,
)
package kr.co.point.common.dto.talent.response

data class TalentMainListDTO (
    var whole : List<TalentListDTO> = ArrayList(),
    var recommend : List<TalentListDTO> = ArrayList(),
    var interest : List<TalentListDTO> = ArrayList(),
)
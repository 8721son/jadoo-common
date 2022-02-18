package kr.co.point.common.repository.talent

import kr.co.point.common.entity.talent.TalentComment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TalentCommentRepository : JpaRepository<TalentComment, Int> {
    fun findByIdx(idx : Int) : Optional<TalentComment>
    fun findByTalentIdx(talent_idx : Int) : List<TalentComment>
}
package kr.co.point.common.repository.talent

import kr.co.point.common.entity.talent.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TalentReplyRepository : JpaRepository<TalentReply, Int> {
}
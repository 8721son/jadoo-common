package kr.co.point.common.repository.member

import kr.co.point.common.entity.member.MemberTag
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MemberTagRepository : JpaRepository<MemberTag, Int> {
    fun findByMemberEmail(member_email: String): List<MemberTag>
    fun deleteByTagIdxAndMemberEmail(tag_idx: Int, member_email: String)
    fun findByTagIdxAndMemberEmail(tag_idx: Int, member_email: String): Optional<MemberTag>
}
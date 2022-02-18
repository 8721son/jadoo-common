package kr.co.point.common.repository.member

import kr.co.point.common.entity.member.MemberNicknameBlacklist
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberNickNameBlackListRepository : JpaRepository<MemberNicknameBlacklist, Int> {
    fun findByNickname(nickname: String): List<MemberNicknameBlacklist>
}
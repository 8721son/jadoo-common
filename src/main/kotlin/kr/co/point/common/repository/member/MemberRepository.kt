package kr.co.point.common.repository.member

import kr.co.point.common.entity.member.Member
import kr.co.point.common.enum_package.status.MemberStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MemberRepository : JpaRepository<Member, Int>{

    fun findByEmailAndStatus(email: String, status: MemberStatus): Optional<Member>
    fun findByEmail(email: String): Optional<Member>
    fun findByNickname(nickname: String): Optional<Member>
    fun findByIdxAndStatus(idx: Int, status: MemberStatus): Optional<Member>

    fun findByOauthApple(oauthApple: String): Optional<Member>
    fun findByOauthGoogle(oauthGoogle: String): Optional<Member>
    fun findByOauthKakao(oauthKakao: String): Optional<Member>

    fun findByUsernameAndHpAndStatusIn(
        username: String,
        hp: String,
        status: List<MemberStatus>
    ): Optional<Member>

    fun findByUsernameAndHp(
        username: String,
        hp: String
    ): Optional<Member>

    fun findByUsernameAndHpAndStatus(
        username: String,
        hp: String,
        status: MemberStatus
    ): Optional<Member>

    fun findByUsernameAndHpAndEmailAndStatus(
        username: String,
        hp: String,
        email: String,
        status: MemberStatus
    ): Optional<Member>

    fun findByIdxInAndStatus(idxList: List<Int>, status: MemberStatus): List<Member>
}
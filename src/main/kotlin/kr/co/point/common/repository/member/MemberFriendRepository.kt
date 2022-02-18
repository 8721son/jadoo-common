package kr.co.point.common.repository.member

import kr.co.point.common.entity.member.MemberFriend
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MemberFriendRepository : JpaRepository<MemberFriend, Int>{
    fun findByMemberEmailAndSelectYn(member_email: String, selectYn: String): Optional<MemberFriend>

    fun findByMemberEmail(member_email: String): List<MemberFriend>

    fun findByMemberEmailAndFriend_Idx(member_email: String,friend_idx : Int) : Optional<MemberFriend>
    fun findTopByMemberEmailOrderByFriend_BrixDesc(member_email: String) : Optional<MemberFriend>
}
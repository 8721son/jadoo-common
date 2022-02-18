package kr.co.point.common.repository.member

import kr.co.point.common.entity.member.MemberMailAuth
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MemberMailAuthRepository : JpaRepository<MemberMailAuth, Int>{
    fun findByCheckYnAndEmailAndCode(checkYn: String, email: String, code: Int): Optional<MemberMailAuth>
    fun deleteByCheckYnAndEmail(checkYn: String, email: String)
    fun deleteByEmail(email: String)
    fun findByEmail(email: String) : Optional<MemberMailAuth>
}
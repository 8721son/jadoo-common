package kr.co.point.common.repository.qna

import kr.co.point.common.entity.qna.Qna
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QnaRepository : JpaRepository<Qna, Int> {
    fun findByDeleteYn(deleteYn: String, pageable: Pageable): Page<Qna>

    fun findByMemberEmailAndDeleteYnOrderByIdxDesc(member_email : String, deleteYn: String, pageable: Pageable): Page<Qna>
}
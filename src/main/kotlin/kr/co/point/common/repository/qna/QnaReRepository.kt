package kr.co.point.common.repository.qna

import kr.co.point.common.entity.qna.Qna
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface QnaReRepository : JpaRepository<Qna, Int>
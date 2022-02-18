package kr.co.point.common.repository.keyword

import kr.co.point.common.entity.search.Keyword
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface KeywordRepository : JpaRepository<Keyword, Int> {
    fun findByDeleteYn(deleteYn: String): List<Keyword>
}
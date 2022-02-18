package kr.co.point.common.repository.md

import kr.co.point.common.entity.md.MD
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MDRepository : JpaRepository<MD, Int> {
    fun findByDeleteYnAndShowYn(deleteYn: String, showYn: String, pageable: Pageable): Page<MD>
}
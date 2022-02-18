package kr.co.point.common.repository.md

import kr.co.point.common.entity.md.MDCategory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MDCategoryRepository : JpaRepository<MDCategory, Int>
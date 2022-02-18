package kr.co.point.common.repository.talent

import kr.co.point.common.entity.talent.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoryRepository : JpaRepository<Category, Int> {
    fun findByCategoryAndUseYn(category: String, userYn: String) : Optional<Category>
}
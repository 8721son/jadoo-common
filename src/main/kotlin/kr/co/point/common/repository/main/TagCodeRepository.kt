package kr.co.point.common.repository.main

import kr.co.point.common.entity.search.TagCode
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TagCodeRepository : JpaRepository<TagCode, Int> {
    fun findByIdx(idx: Int) : Optional<TagCode>;
    fun findByNameLike(name: String): List<TagCode>
    fun findByName(name: String): Optional<TagCode>
    fun findByNameContains(name : String) : List<TagCode>;
}
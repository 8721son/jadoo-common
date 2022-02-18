package kr.co.point.common.repository.talent

import kr.co.point.common.entity.talent.TalentTag
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TalentTagRepository : JpaRepository<TalentTag, Int> {
}
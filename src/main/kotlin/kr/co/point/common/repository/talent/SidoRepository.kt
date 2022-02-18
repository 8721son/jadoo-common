package kr.co.point.common.repository.talent

import kr.co.point.common.entity.talent.Sido
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SidoRepository : JpaRepository<Sido, Int> {

}
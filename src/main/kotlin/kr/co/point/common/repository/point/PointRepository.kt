package kr.co.point.common.repository.point

import kr.co.point.common.entity.point.Point
import kr.co.point.common.enum_package.type.PointType
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime
import java.time.Month

@Repository
interface PointRepository : JpaRepository<Point, Int> {
    fun findByMemberEmail(member_email: String): List<Point>
    fun findByMember_EmailAndCreateDateAfter(member_email: String, date : LocalDateTime) : List<Point>
    fun findByMemberEmailAndPointTypeIn(member_email: String,pointType : List<PointType>): List<Point>
    fun findByMemberEmailAndPointTypeOrderByCreateDateDesc(member_email: String,pointType : PointType,pageable: Pageable): Page<Point>
}
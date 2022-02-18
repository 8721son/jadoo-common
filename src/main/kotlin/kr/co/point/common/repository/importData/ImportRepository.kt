package kr.co.point.common.repository.importData

import kr.co.point.common.entity.importData.Import
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ImportRepository : JpaRepository<Import, Int>{
    fun findByOrderId(orderId : String) : Optional<Import>
}
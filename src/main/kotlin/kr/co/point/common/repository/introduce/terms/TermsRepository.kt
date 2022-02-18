package kr.co.point.common.repository.introduce.terms

import kr.co.point.common.entity.introduce.Terms
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TermsRepository : JpaRepository<Terms, Int>{
    fun findByYakkwanYn(yakkwanYn: String,sort: Sort): List<Terms>
    fun findByGaeinYn(gaeinYn: String,sort: Sort): List<Terms>
    fun findByCoupangYn(coupangYn: String,sort: Sort): List<Terms>
}
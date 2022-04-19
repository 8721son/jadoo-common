package kr.co.point.common.repository.member

import kr.co.point.common.entity.member.MemberDeliveryAddress
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MemberDeliveryAddressRepository : JpaRepository<MemberDeliveryAddress, Int> {
    fun findByMember_Email(email:String) : List<MemberDeliveryAddress>
    fun findByIdxAndMember_Idx(idx:Int, member_idx:Int) : Optional<MemberDeliveryAddress>
    fun deleteByIdxAndMember_Email(idx: Int, email: String)

}
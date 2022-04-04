package kr.co.point.common.repository.member

import kr.co.point.common.entity.member.MemberDeliveryAddress
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberDeliveryAddressRepository : JpaRepository<MemberDeliveryAddress, Int> {
}
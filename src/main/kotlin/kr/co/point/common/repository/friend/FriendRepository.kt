package kr.co.point.common.repository.friend

import kr.co.point.common.entity.friend.Friend
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FriendRepository : JpaRepository<Friend, Int>{
    fun findByBrix(brix : Int) : Optional<Friend>
    fun findTopByBrixGreaterThanOrderByBrix(brix: Int): Optional<Friend>
    fun findByBrixLessThanOrderByBrixAsc(brix: Int) : List<Friend>
}
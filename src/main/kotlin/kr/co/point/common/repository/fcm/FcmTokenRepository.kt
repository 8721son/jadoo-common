package kr.co.point.common.repository.fcm

import kr.co.point.common.entity.fcm.FcmToken
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FcmTokenRepository : JpaRepository<FcmToken, Int>{
    fun findByToken(token: String): Optional<FcmToken>
    fun findBySsaid(ssaid: String): Optional<FcmToken>
}
package kr.co.point.common.entity.member

import kr.co.point.common.dto.member.MemberDTO
import kr.co.point.common.dto.member.request.JoinRequestDTO
import kr.co.point.common.dto.member.response.MyEditDTO
import kr.co.point.common.entity.file.File
import kr.co.point.common.enum_package.status.MemberStatus
import kr.co.point.common.enum_package.type.RoleType
import kr.co.point.common.util.getLocalDateTimeToString
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
class Member {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, insertable = false)
        var idx: Int? = null

        var username: String = ""
                get() {
                         return String(Base64.getDecoder().decode(field))
                }
                set(value){
                        field = Base64.getEncoder().encodeToString(value.toByteArray())
                }
        var nickname: String = ""
        var password: String = ""

        @Column(unique = true)
        var email: String = ""

        var hp: String = ""
                get() {
                        return String(Base64.getDecoder().decode(field))
                }
                set(value){
                        field = Base64.getEncoder().encodeToString(value.toByteArray())
                }

        var birth: String = ""
                get() {
                        return String(Base64.getDecoder().decode(field))
                }
                set(value){
                        field = Base64.getEncoder().encodeToString(value.toByteArray())
                }

        var totalPoint: Int = 0
        var iamportUid: String? = null

        @OneToOne(targetEntity = File::class)
        @JoinColumn(name = "profile_idx", referencedColumnName = "idx")
        var profileImg: File? = null
        var profileOpenYn : String = "N"

        var oauthGoogle: String? = null
        var oauthKakao: String? = null
        var oauthApple: String? = null
        // Enum Type 변경
        // Sanction 제재
        // Delete 회원탈퇴
        // Normal 정상적인
        @Enumerated(EnumType.STRING)
        var status: MemberStatus = MemberStatus.NORMAL

        @Enumerated(EnumType.STRING)
        var role: RoleType = RoleType.MEMBER

        @CreationTimestamp
        var createDate: LocalDateTime? = null

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null

        var loginDate: LocalDateTime? = null

        var googleAuthDate: LocalDateTime? = null
        var appleAuthDate: LocalDateTime? = null
        var kakaoAuthDate: LocalDateTime? = null

        var reason: String? = null

        fun toDTO(): MemberDTO {
                val memberDTO = MemberDTO()
                memberDTO.idx = idx!!
                memberDTO.username = username
                memberDTO.nickname = nickname
                memberDTO.password = password
                memberDTO.email = email
                memberDTO.hp = hp
                memberDTO.birth = birth
                memberDTO.totalPoint = totalPoint
                memberDTO.status = status
                memberDTO.role = role
                memberDTO.createDate = createDate
                memberDTO.loginDate = loginDate
                memberDTO.oauthApple = oauthApple!!
                memberDTO.oauthGoogle = oauthGoogle!!
                memberDTO.oauthKakao = oauthKakao!!
                memberDTO.iamportUid = iamportUid!!
                return memberDTO
        }

        fun joinDTO_EntitySet (
                joinRequestDTO: JoinRequestDTO,
                bCryptPasswordEncoder: BCryptPasswordEncoder
        ) {
                username = joinRequestDTO.name
                nickname = joinRequestDTO.nickname
                password = bCryptPasswordEncoder.encode(joinRequestDTO.password)
                email = joinRequestDTO.email
                hp = joinRequestDTO.phone
                totalPoint = 0
                status = MemberStatus.NORMAL
                role = RoleType.MEMBER
                profileOpenYn = joinRequestDTO.profileOpenYn
                createDate = LocalDateTime.now()
                iamportUid = joinRequestDTO.iamportUid
                oauthGoogle = ""
                oauthApple = ""
                oauthKakao = ""
                if (joinRequestDTO.profile != null) {
                        profileImg = joinRequestDTO.profile!!.toEntity()
                }


                when (joinRequestDTO.provider) {
                    "google" -> {
                            oauthGoogle = joinRequestDTO.oauthToken
                            googleAuthDate = LocalDateTime.now()
                    }
                    "apple" -> {
                            oauthApple = joinRequestDTO.oauthToken
                            appleAuthDate = LocalDateTime.now()
                    }
                    "kakao" -> {
                            oauthKakao = joinRequestDTO.oauthToken
                            kakaoAuthDate = LocalDateTime.now()
                    }
                }
        }

        fun toMyEditDTO(): MyEditDTO {
                val myEditDTO = MyEditDTO();
                myEditDTO.idx = idx!!
                myEditDTO.nickname = nickname
                myEditDTO.name = username
                myEditDTO.email = email
                myEditDTO.birth = birth
                myEditDTO.phone = hp
                myEditDTO.profileImg = if (profileImg == null) null else profileImg!!.toDTO()
                myEditDTO.googleAuthDate = if (googleAuthDate == null) "" else getLocalDateTimeToString(googleAuthDate!!)
                myEditDTO.kakaoAuthDate = if (kakaoAuthDate == null) "" else  getLocalDateTimeToString(kakaoAuthDate!!)
                myEditDTO.appleAuthDate = if (appleAuthDate == null) "" else  getLocalDateTimeToString(appleAuthDate!!)
                myEditDTO.brix = totalPoint
                myEditDTO.appleAuthYn = appleAuthDate != null
                myEditDTO.googleAuthYn = googleAuthDate != null
                myEditDTO.kakaoAuthYn = kakaoAuthDate != null
                return myEditDTO
        }

}
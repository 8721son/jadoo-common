package kr.co.point.common.entity.member

import javax.persistence.*

@Entity
class MemberNicknameBlacklist {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, insertable = false)
        var idx: Int? = null

        var nickname: String = ""

}
package kr.co.point.common.entity.fcm

import kr.co.point.common.entity.member.Member
import kr.co.point.common.enum_package.type.PushType
import kr.co.point.common.enum_package.type.YAndNType
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class FcmPush(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, insertable = false)
        var idx: Int? = null,

        @ManyToOne(targetEntity = Member::class)
        @JoinColumn(name = "member_idx", referencedColumnName = "idx")
        var member: Member? = null,

        @ManyToOne(targetEntity = FcmToken::class)
        @JoinColumn(name = "token_idx", referencedColumnName = "idx")
        var token: FcmToken? = null,

        @Enumerated(EnumType.STRING)
        val read_yn: YAndNType = YAndNType.N,

        @Enumerated(EnumType.STRING)
        var pushType: PushType = PushType.ADMIN,

        var title: String = "",
        var msg: String = "",
        var data: String = "",

        @CreationTimestamp
        var createDate: LocalDateTime? = null,

) {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as FcmPush

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , member = $member , token = $token , read_yn = $read_yn , pushType = $pushType , title = $title , msg = $msg , data = $data , createDate = $createDate )"
        }
}
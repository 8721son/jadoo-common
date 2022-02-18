package kr.co.point.common.entity.member

import kr.co.point.common.dto.friend.reponse.AboutFriendDTO
import kr.co.point.common.dto.friend.reponse.CommonInfoFriendDTO
import kr.co.point.common.entity.friend.Friend
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class MemberFriend(
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, insertable = false)
        var idx: Int? = null,

    var selectYn: String? = null,

    @ManyToOne(targetEntity = Member::class)
    @JoinColumn(name = "member_idx", referencedColumnName = "idx")
    var member: Member = Member(),

    @ManyToOne(targetEntity = Friend::class)
    @JoinColumn(name = "friend_idx", referencedColumnName = "idx")
    var friend: Friend = Friend(),

    @CreationTimestamp
    var createDate: LocalDateTime? = null,

    @UpdateTimestamp
    var updateDate: LocalDateTime? = null,
) {
    fun toAboutDTO(): CommonInfoFriendDTO {
        val aboutFriend = CommonInfoFriendDTO();
        aboutFriend.idx=idx!!
        aboutFriend.name=friend.name
        aboutFriend.nameKor=friend.nameKor
        aboutFriend.color=friend.color
        aboutFriend.graBegin=friend.gradientBegin
        aboutFriend.graEnd=friend.gradientEnd
        aboutFriend.content=friend.content
        aboutFriend.summary=friend.summary
        aboutFriend.title=friend.title
        aboutFriend.brixImg=friend.brixImg.toDTO()
        aboutFriend.icon=friend.iconImg.toDTO()
        aboutFriend.iconWave=friend.iconWaveImg.toDTO()
        aboutFriend.iconDisable=friend.iconDisableImg.toDTO()
        aboutFriend.iconEnable=friend.iconEnableImg.toDTO()
        aboutFriend.iconFull=friend.iconFullImg.toDTO()
        aboutFriend.brix = friend.brix
        return aboutFriend
    }
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as MemberFriend

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , selectYn = $selectYn , member = $member , friend = $friend , createDate = $createDate , updateDate = $updateDate )"
        }
}
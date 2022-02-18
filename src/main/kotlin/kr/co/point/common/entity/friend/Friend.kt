package kr.co.point.common.entity.friend

import kr.co.point.common.dto.friend.reponse.AboutFriendDTO
import kr.co.point.common.entity.file.File
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Friend(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, insertable = false)
        var idx: Int? = null,

        var name: String = "",
        var nameKor: String = "",
        var color: String = "",
        var gradientBegin: String = "",
        var gradientEnd: String = "",
        var summary: String = "",
        var content: String = "",
        var title: String = "",

        var brix: Int = 0,

        @OneToOne(targetEntity = File::class)
        @JoinColumn(name = "brix_img_idx", referencedColumnName = "idx")
        var brixImg: File = File(),

        @OneToOne(targetEntity = File::class)
        @JoinColumn(name = "icon_img_idx", referencedColumnName = "idx")
        var iconImg: File = File(),

        @OneToOne(targetEntity = File::class)
        @JoinColumn(name = "wave_img_idx", referencedColumnName = "idx")
        var iconWaveImg: File = File(),

        @OneToOne(targetEntity = File::class)
        @JoinColumn(name = "disable_img_idx", referencedColumnName = "idx")
        var iconDisableImg: File = File(),

        @OneToOne(targetEntity = File::class)
        @JoinColumn(name = "enable_img_idx", referencedColumnName = "idx")
        var iconEnableImg: File = File(),

        @OneToOne(targetEntity = File::class)
        @JoinColumn(name = "full_img_idx", referencedColumnName = "idx")
        var iconFullImg: File = File(),

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
) {
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as Friend

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , name = $name , nameKor = $nameKor , color = $color , gradientBegin = $gradientBegin , gradientEnd = $gradientEnd , summary = $summary , content = $content , title = $title , brix = $brix , brixImg = $brixImg , iconImg = $iconImg , iconWaveImg = $iconWaveImg , iconDisableImg = $iconDisableImg , iconEnableImg = $iconEnableImg , iconFullImg = $iconFullImg , createDate = $createDate , updateDate = $updateDate )"
        }

        fun toAboutDTO(): AboutFriendDTO {
                val aboutFriend = AboutFriendDTO();
                aboutFriend.idx=idx!!
                aboutFriend.name=name
                aboutFriend.nameKor=nameKor
                aboutFriend.color=color
                aboutFriend.graBegin=gradientBegin
                aboutFriend.graEnd=gradientEnd
                aboutFriend.content=content
                aboutFriend.summary=summary
                aboutFriend.title=title
                aboutFriend.brixImg=brixImg.toDTO()
                aboutFriend.icon=iconImg.toDTO()
                aboutFriend.iconWave=iconWaveImg.toDTO()
                aboutFriend.iconDisable=iconDisableImg.toDTO()
                aboutFriend.iconEnable=iconEnableImg.toDTO()
                aboutFriend.iconFull=iconFullImg.toDTO()
                aboutFriend.brix = brix
                return aboutFriend
        }
}
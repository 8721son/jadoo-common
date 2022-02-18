package kr.co.point.common.entity.qna

import kr.co.point.common.dto.qna.response.QnaDTO
import kr.co.point.common.dto.qna.response.QnaDetailDTO
import kr.co.point.common.entity.file.File
import kr.co.point.common.entity.member.Member
import kr.co.point.common.enum_package.type.MemberType
import kr.co.point.common.util.getDateYYmmdd
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Qna(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, insertable = false)
        var idx: Int? = null,

        @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member::class)
        @JoinColumn(name = "member_idx", referencedColumnName = "idx")
        var member: Member? = null,

        @Enumerated(EnumType.STRING)
        var type : MemberType = MemberType.NON_MEMBER,

        var email : String = "",

        var category : String? = "",

        @OneToOne(fetch = FetchType.EAGER, targetEntity = QnaRe::class)
        @JoinColumn(name = "re_idx", referencedColumnName = "idx")
        var re: QnaRe? = null,

        var title: String = "",
        var content: String = "",

        var deleteYn: String = "N",

        @OneToOne(targetEntity = File::class)
        @JoinColumn(name = "file_idx", referencedColumnName = "idx")
        var file: File? = null,

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
        var deleteDate: LocalDateTime? = null,
) {
        fun toDTO(): QnaDTO {
              return QnaDTO(idx!!, title, getDateYYmmdd(createDate),content, re != null && re!!.idx != null)
        }

        fun toDetail(): QnaDetailDTO {
                return QnaDetailDTO(
                        idx!!, title, getDateYYmmdd(createDate), content,
                        file?.toDTO(), re?.title,
                        if (re != null) getDateYYmmdd(re!!.createDate) else getDateYYmmdd(LocalDateTime.now()),
                        re?.content, re?.file?.toDTO()
                )
        }

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as Qna

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , member = $member , re = $re , title = $title , content = $content , deleteYn = $deleteYn , createDate = $createDate , updateDate = $updateDate , deleteDate = $deleteDate )"
        }
}
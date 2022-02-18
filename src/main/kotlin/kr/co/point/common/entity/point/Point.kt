package kr.co.point.common.entity.point

import kr.co.point.common.dto.point.PointDTO
import kr.co.point.common.dto.point.response.MyPointDetailDTO
import kr.co.point.common.entity.member.Member
import kr.co.point.common.enum_package.type.PointType
import kr.co.point.common.util.getDate
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Point(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, insertable = false)
        var idx: Int? = null,

        @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member::class)
        @JoinColumn(name = "member_idx", referencedColumnName = "idx")
        var member: Member = Member(),

        @Enumerated(EnumType.STRING)
        var pointType: PointType = PointType.EXPECTATION,

        var description: String = "",
        var count: Int = 0,
        var point: Int = 0,

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
) {


        fun toPointDTO(): PointDTO {
                return PointDTO(
                        idx!!,
                        member.toDTO(),
                        pointType,
                        description,
                        point,
                        count,
                )
        }

        fun toMyPointDetailDTO(): MyPointDetailDTO {
                return MyPointDetailDTO(
                        idx!!,
                        description,
                        count,
                        getDate(createDate),
                        point,

                )
        }

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as Point

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , member = $member , pointType = $pointType , description = $description , count = $count , point = $point , createDate = $createDate , updateDate = $updateDate )"
        }
}
package kr.co.point.common.entity.coupang.match

import kr.co.point.common.entity.coupang.api.CoupangApi
import kr.co.point.common.entity.coupang.crawling.CoupangCrawling
import kr.co.point.common.entity.member.Member
import kr.co.point.common.entity.point.Point
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class CoupangMatch(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @OneToOne(targetEntity = CoupangApi::class)
    @JoinColumn(name = "api_idx", referencedColumnName = "idx")
    var coupangApi: CoupangApi = CoupangApi(),

    @OneToOne(targetEntity = CoupangCrawling::class)
    @JoinColumn(name = "crawling_idx", referencedColumnName = "idx")
    var coupangCrawling: CoupangCrawling = CoupangCrawling(),

    @OneToOne(targetEntity = Point::class)
    @JoinColumn(name = "point_idx", referencedColumnName = "idx")
    var point: Point? = Point(),

    @ManyToOne(targetEntity = Member::class)
    @JoinColumn(name = "member_idx", referencedColumnName = "idx")
    var member: Member = Member(),

    var directYn: String? = null,

    @CreationTimestamp
    var createDate: LocalDateTime? = null,

    @UpdateTimestamp
    var updateDate: LocalDateTime? = null,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as CoupangMatch

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , coupangApi = $coupangApi , coupangCrawling = $coupangCrawling , point = $point , member = $member , directYn = $directYn , createDate = $createDate , updateDate = $updateDate )"
    }
}

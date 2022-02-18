package kr.co.point.common.entity.talent

import kr.co.point.common.dto.talent.response.SigunguDTO
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Sigungu(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, insertable = false)
    var idx: Int? = null,

    var deleteYn: String = "N",

    var sigungu: String = "",

    @ManyToOne(targetEntity = Sido::class)
    @JoinColumn(name = "sido_idx", referencedColumnName = "idx")
    var sido: Sido? = null,

    @CreationTimestamp
    var createDate: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updateDate: LocalDateTime? = null,
){
    fun toDTO(): SigunguDTO{
        return SigunguDTO(sigungu);
    }

    fun changeSido(sido: Sido) {
        if (this.sido != null) {
            this.sido = null
        }

        this.sido = sido
        sido.sigungu.add(this)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Sigungu

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , deleteYn = $deleteYn , sigungu = $sigungu , sido = $sido , createDate = $createDate , updateDate = $updateDate )"
    }
}

package kr.co.point.common.entity.talent

import kr.co.point.common.dto.talent.response.SidoDTO
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Sido(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, insertable = false)
    var idx: Int? = null,

    var deleteYn: String = "N",

    var sido: String = "",

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sido", cascade = [CascadeType.ALL], orphanRemoval = true)
    var sigungu: MutableList<Sigungu> = ArrayList(),

    @CreationTimestamp
    var createDate: LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updateDate: LocalDateTime? = null,
){
    fun toDTO(): SidoDTO {
        return SidoDTO(
            name = sido,
            sigungu = sigungu!!.stream().map(Sigungu::toDTO).toList()
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Sido

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , deleteYn = $deleteYn , sido = $sido , createDate = $createDate , updateDate = $updateDate )"
    }
}

package kr.co.point.common.entity.coupang.product

import kr.co.point.common.dto.coupang.response.CoupangCategoryDTO
import kr.co.point.common.entity.file.File
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class CoupangCategory(

    // 1001	여성패션
    // 1002	남성패션
    // 1010	뷰티
    // 1011	출산/유아동
    // 1012	식품
    // 1013	주방용품
    // 1014	생활용품
    // 1015	홈인테리어
    // 1016	가전디지털
    // 1017	스포츠/레저
    // 1018	자동차용품
    // 1019	도서/음반/DVD
    // 1020	완구/취미
    // 1021	문구/오피스
    // 1024	헬스/건강식품
    // 1025	국내여행
    // 1026	해외여행
    // 1029	반려동물용품
    // 1030	유아동패션
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @OneToOne(targetEntity = File::class)
    @JoinColumn(name = "photo_idx", referencedColumnName = "idx")
    var photo: File = File(),

    var name: String = "",

    var showYn: String = "N",
    var deleteYn: String = "N",

    @CreationTimestamp
    var createDate: LocalDateTime? = null,

    @UpdateTimestamp
    var updateDate: LocalDateTime? = null,

    var deleteDate: LocalDateTime? = null,
) {

    fun toDTO () : CoupangCategoryDTO {
        return CoupangCategoryDTO(idx!!, name, photo.toDTO())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as CoupangCategory

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , photo = $photo , name = $name , showYn = $showYn , deleteYn = $deleteYn , createDate = $createDate , updateDate = $updateDate , deleteDate = $deleteDate )"
    }

}

package kr.co.point.common.entity.md

import kr.co.point.common.dto.md.response.MDDTO
import kr.co.point.common.entity.file.File
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class MD(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    @OneToOne(targetEntity = File::class)
    @JoinColumn(name = "photo_idx", referencedColumnName = "idx")
    var photo: File = File(),

    var title: String = "",

    @ManyToOne(targetEntity = MDCategory::class)
    @JoinColumn(name="category_idx", referencedColumnName = "idx")
    var category: MDCategory = MDCategory(),

    var discountRate : Double = 0.0,
    var price : Int = 0,

    var deleteYn: String = "N",
    var showYn: String = "N",

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updateDate : LocalDateTime? = null,

    var deleteDate : LocalDateTime? = null,
) {

    fun toDTO() : MDDTO {
        return MDDTO(
            idx,
            photo.toDTO(),
            title,
            category.name,
            discountRate,
            price,
            createDate.isAfter(LocalDateTime.now().minusDays(30))
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as MD

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , photo = $photo , title = $title , category = $category , discountRate = $discountRate , price = $price , deleteYn = $deleteYn , showYn = $showYn , createDate = $createDate , updateDate = $updateDate , deleteDate = $deleteDate )"
    }
}
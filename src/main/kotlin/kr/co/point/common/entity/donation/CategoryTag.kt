package kr.co.point.common.entity.donation

import kr.co.point.common.dto.search.response.TagDTO
import kr.co.point.common.entity.search.TagCode
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class CategoryTag(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var idx: Int? = null,

        @ManyToOne(targetEntity = TagCode::class)
        @JoinColumn(name = "tag_idx", referencedColumnName = "idx")
        var tag: TagCode = TagCode(),

        @ManyToOne(targetEntity = Category::class)
        @JoinColumn(name = "category_idx", referencedColumnName = "idx")
        var category: Category= Category(),

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
) {

        fun toDTO() : TagDTO {
                return TagDTO(tag.idx!!,tag.name)
        }
}
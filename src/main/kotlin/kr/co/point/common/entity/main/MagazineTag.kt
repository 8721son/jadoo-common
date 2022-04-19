package kr.co.point.common.entity.main

import kr.co.point.common.entity.search.TagCode
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class MagazineTag(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var idx: Int? = null,

        @ManyToOne(targetEntity = TagCode::class)
        @JoinColumn(name = "tag_idx", referencedColumnName = "idx")
        var tag: TagCode = TagCode(),

        @ManyToOne(targetEntity = Magazine::class)
        @JoinColumn(name = "magazine_idx", referencedColumnName = "idx")
        var magazine: Magazine = Magazine(),

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
)
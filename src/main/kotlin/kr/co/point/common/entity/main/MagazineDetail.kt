package kr.co.point.common.entity.main

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class MagazineDetail(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    var link : String = "",
    var contentUrl : String = "",

    @CreationTimestamp
    var createDate: LocalDateTime? = null,

    @UpdateTimestamp
    var updateDate: LocalDateTime? = null,

)
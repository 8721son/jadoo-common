package kr.co.point.common.entity.main

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class MagazineRequest(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,
    var store : String = "",
    var phone : String = "",
    var email : String = "",

    @CreationTimestamp
    var createDate: LocalDateTime? = null,


)
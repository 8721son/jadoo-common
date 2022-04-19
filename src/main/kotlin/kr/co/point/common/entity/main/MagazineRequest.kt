package kr.co.point.common.entity.main

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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MagazineRequest

        if (idx != other.idx) return false
        if (store != other.store) return false
        if (phone != other.phone) return false
        if (email != other.email) return false

        return true
    }

    override fun hashCode(): Int {
        var result = idx ?: 0
        result = 31 * result + store.hashCode()
        result = 31 * result + phone.hashCode()
        result = 31 * result + email.hashCode()
        return result
    }

    override fun toString(): String {
        return "MagazineRequest(idx=$idx, store='$store', phone='$phone', email='$email')"
    }


}
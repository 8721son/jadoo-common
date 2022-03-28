package kr.co.point.common.entity.partners

import kr.co.point.common.dto.partners.response.MainPartnerstDTO
import kr.co.point.common.dto.partners.response.PartnersDTO
import kr.co.point.common.entity.file.File
import kr.co.point.common.enum_package.status.MemberStatus
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Partners(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var idx: Int? = null,

    var password : String = "",
    var hp : String = "",
    var business_name : String = "",
    var companyRegistrationNumber : Int = 0,

    @OneToOne(targetEntity = File::class)
    @JoinColumn(name = "logo_img", referencedColumnName = "idx")
    var logoImg : File = File(),

    @OneToOne(targetEntity = File::class)
    @JoinColumn(name = "main_img", referencedColumnName = "idx")
    var mainImg : File? = null,

    var description : String? = null,

    @Enumerated(EnumType.STRING)
    var status : MemberStatus = MemberStatus.NORMAL,

    var loginDate : LocalDateTime? = null,

    @CreationTimestamp
    var createDate : LocalDateTime = LocalDateTime.now(),

    @UpdateTimestamp
    var updateDate : LocalDateTime? = null,

    var reason : String? = null,
){
    fun toDTO() : PartnersDTO{
        return PartnersDTO(
            idx,
            hp,
            business_name,
            companyRegistrationNumber,
            logoImg.toDTO(),
            if(mainImg!=null) mainImg!!.toDTO() else null,
            description,
            status
        )
    }

    fun toMainDTO() : MainPartnerstDTO {
        return MainPartnerstDTO(
            idx!!,
            logoImg.toDTO(),
            business_name
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Partners

        return idx != null && idx == other.idx
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(idx = $idx , password = $password , hp = $hp , business_name = $business_name , companyRegistrationNumber = $companyRegistrationNumber , logoImg = $logoImg , mainImg = $mainImg , description = $description , status = $status , loginDate = $loginDate , createDate = $createDate , updateDate = $updateDate , reason = $reason )"
    }

}
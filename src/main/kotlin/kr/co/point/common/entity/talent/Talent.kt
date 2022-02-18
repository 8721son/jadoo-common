package kr.co.point.common.entity.talent

import kr.co.point.common.dto.talent.response.TalentDetailDTO
import kr.co.point.common.dto.talent.response.TalentListDTO
import kr.co.point.common.dto.talent.response.TalentResponseDTO
import kr.co.point.common.entity.file.File
import kr.co.point.common.entity.member.Member
import org.hibernate.Hibernate
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Talent(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(updatable = false, insertable = false)
        var idx: Int? = null,

        @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member::class)
        @JoinColumn(name = "member_idx", referencedColumnName = "idx")
        var organizer: Member = Member(),

        var title: String = "",

        var recruitStartDate : LocalDateTime? = null,
        var recruitEndDate : LocalDateTime? = null,

        var startDate : LocalDateTime? = null,
        var endDate : LocalDateTime? = null,
        var startTime : String = "",
        var endTime : String = "",

        var onlineYn : String ? = "N",

        var url: String? = "",

        var address: String? = "",
        var detailAddress: String? = "",

        var longitude: Double? = 0.0,
        var latitude: Double? = 0.0,

        var totalRecruit: Int = 0,

        var description : String = "",

        var cancelYn: String = "N",
        var cancelReason: String? = "",

        var type: String? = "",

        @ManyToOne(targetEntity = Category::class)
        @JoinColumn(name = "talent_category_idx", referencedColumnName = "idx")
        var category: Category? = null,

        @OneToMany(mappedBy = "talent", cascade = [CascadeType.ALL], orphanRemoval = true)
        var notice: MutableList<TalentNotice>? = null,

        @OneToMany(mappedBy = "talent", cascade = [CascadeType.ALL], orphanRemoval = true)
        var comments: MutableList<TalentComment>? = null,

        @OneToMany(mappedBy = "talent", cascade = [CascadeType.ALL], orphanRemoval = true)
        var tag: MutableList<TalentTag>? = null,

        @OneToMany(mappedBy = "talent", cascade = [CascadeType.ALL], orphanRemoval = true)
        var participant: MutableList<TalentAttendance>? = null,

        @OneToOne(targetEntity = File::class)
        @JoinColumn(name = "file_idx", referencedColumnName = "idx")
        var file: File? = null,

        @CreationTimestamp
        var createDate: LocalDateTime = LocalDateTime.now(),

        @UpdateTimestamp
        var updateDate: LocalDateTime? = null,
        var cancelDate: LocalDateTime? = null,
) {

        fun toDetailDTO() : TalentDetailDTO{
                return TalentDetailDTO(
                        idx,
                        organizer,
                        title,
                        recruitStartDate,
                        recruitEndDate,
                        startDate,
                        endDate,
                        startTime,
                        endTime,
                        onlineYn,
                        url,
                        address,
                        detailAddress,
                        longitude,
                        latitude,
                        totalRecruit,
                        description,
                        cancelYn,
                        cancelReason,
                        type,
                        category,
                        notice,
                        comments,
                        tag,
                        participant,
                        file
                )
        }


        fun toListDTO() : TalentListDTO{
                return TalentListDTO(
                        file,
                        title,
                        address!!,
                        startDate,
                        endDate,
                        tag!!.stream().map(TalentTag::tag).toList(),
                        totalRecruit
                )
        }

        fun toDTO(): TalentResponseDTO {
                return TalentResponseDTO(
                        idx,
                        organizer.username,
                        title,
                        recruitStartDate,
                        recruitEndDate,
                        startDate,
                        endDate,
                        startTime,
                        endTime,
                        address,
                        detailAddress,
                        totalRecruit,
                        description,
                        category,
                        null,
                        file,
                        null
                )
        }

        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
                other as Talent

                return idx != null && idx == other.idx
        }

        override fun hashCode(): Int = javaClass.hashCode()

        @Override
        override fun toString(): String {
                return this::class.simpleName + "(idx = $idx , organizer = $organizer , title = $title , recruitStartDate = $recruitStartDate , recruitEndDate = $recruitEndDate , startDate = $startDate , endDate = $endDate , startTime = $startTime , endTime = $endTime , onlineYn = $onlineYn , url = $url , address = $address , detailAddress = $detailAddress , longitude = $longitude , latitude = $latitude , totalRecruit = $totalRecruit , description = $description , cancelYn = $cancelYn , cancelReason = $cancelReason , type = $type , category = $category , file = $file , createDate = $createDate , updateDate = $updateDate , cancelDate = $cancelDate )"
        }

}
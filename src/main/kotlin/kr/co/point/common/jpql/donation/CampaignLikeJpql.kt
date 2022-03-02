package kr.co.point.common.jpql.donation

import kr.co.point.common.dto.donation.v1.request.CampaignFilterV1RequestDTO
import kr.co.point.common.dto.donation.v2.request.CampaignFilterV2RequestDTO
import kr.co.point.common.entity.donation.Campaign
import kr.co.point.common.entity.donation.CampaignLike
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import javax.persistence.EntityManager

class CampaignLikeJpql(private val em: EntityManager) {

    fun search(
        pageable: Pageable,
        member_idx : Int,
        campaignFilterRequestDTO: CampaignFilterV2RequestDTO,
    ) : Page<CampaignLike>{


        var condition : String = ""

        // list

        val conditionList : MutableList<String> = ArrayList()

        // filter 1
        // list add  now()< c.startDate
        val contain : String = when (campaignFilterRequestDTO.status) {
            "모금 예정" -> "now()< c.campaign.startDate"
            "모금 중"   -> "now()> c.campaign.startDate and c.campaign.endDate > now()"
            "모금 마감" -> "c.campaign.endDate < now()"
            else       -> ""
        }

        if(contain != ""){
            conditionList.add(contain)
        }

        // filter 2
        // list add
        val categoryIdx : Int = campaignFilterRequestDTO.category
        var category: String = ""
        if(categoryIdx!=0){
            category = "c.campaign.category.idx=$categoryIdx"
            conditionList.add(category)
        }


        // list size > 0
        // where 값 + and
        // 마지막만 주의
        condition += "where c.member.idx=$member_idx"

        if(conditionList.isNotEmpty()){
            for(i in 1..conditionList.size){
                condition += " and "
                condition += conditionList[i-1]
            }
        }

        val order : String = if(campaignFilterRequestDTO.start == "오래된 순") "desc" else "asc"

        val query = "select c from CampaignLike c join CampaignTag t on c.campaign.idx = t.campaign.idx $condition order by c.campaign.startDate $order"


        val createTotalQuery = em.createQuery("select count(c) from CampaignLike c $condition", Long::class.javaObjectType);
        val total = createTotalQuery.singleResult

        val createQuery = em.createQuery(query, CampaignLike::class.java)
        createQuery.firstResult = pageable.offset.toInt()
        createQuery.maxResults = pageable.pageSize

        return PageImpl(createQuery.resultList, pageable,total)
    }

}
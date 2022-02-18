package kr.co.point.common.jpql.talent

import kr.co.point.common.dto.talent.request.TalentFilterRequestDTO
import kr.co.point.common.entity.donation.Campaign
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import javax.persistence.EntityManager

class TalentJpql(private val em: EntityManager) {

    fun search(
        pageable : Pageable,
        talentFilterRequestDTO: TalentFilterRequestDTO,
    ) : Page<Campaign> {


        val order : String = if(talentFilterRequestDTO.recruitStartDate == "오래된 순"){
            "t.recruitStartDate asc";
        }else{
            "t.recruitStartDate desc";
        }


        val query = "select t from Talent t order by $order"

        val createTotalQuery = em.createQuery("select t from Talent t order by $order", Long::class.javaObjectType);
        val total = createTotalQuery.singleResult

        val createQuery = em.createQuery(query, Campaign::class.java)
        createQuery.firstResult = pageable.offset.toInt()
        createQuery.maxResults = pageable.pageSize

        return PageImpl(createQuery.resultList, pageable,total)
    }
}
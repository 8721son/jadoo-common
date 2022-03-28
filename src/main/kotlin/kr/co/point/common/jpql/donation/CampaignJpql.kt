package kr.co.point.common.jpql.donation

import kr.co.point.common.dto.donation.v1.request.CampaignFilterV1RequestDTO
import kr.co.point.common.dto.donation.v2.request.CampaignFilterV2RequestDTO
import kr.co.point.common.entity.donation.Campaign
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import javax.persistence.EntityManager

class CampaignJpql(private val em: EntityManager) {

    fun searchV1(
        pageable: Pageable,
        campaignFilterV1RequestDTO: CampaignFilterV1RequestDTO,
        ) : Page<Campaign>{

            var queryV1 = "select d from Campaign d "
            val title = campaignFilterV1RequestDTO.title

            val createTotalQueryV1 = em.createQuery("select count(d) from Campaign d", Long::class.javaObjectType)
            val contain : String = if(title == ""){
                when (campaignFilterV1RequestDTO.option2) {
                    "모금 예정" -> "where now()< c.startDate"
                    "모금 중"   -> "where now()> c.startDate and c.endDate > now()"
                    "모금 마감" -> "where c.endDate < now()"
                    else       -> ""
                }
            } else {
                when (campaignFilterV1RequestDTO.option2) {
                    "모금 예정" -> "where c.title like '%$title%' and now()< c.startDate"
                    "모금 중"   -> "where c.title like '%$title%' and now()> c.startDate and c.endDate > now()"
                    "모금 마감" -> "where c.title like '%$title%' and c.endDate < now()"
                    else       -> "where c.title like '%$title%'"
                }
            }
            val order : String = if(campaignFilterV1RequestDTO.option1 == "오래된 순") "desc" else "asc"

            val query = "select c from Campaign c $contain order by c.startDate $order"

            val createTotalQuery = em.createQuery("select count(c) from Campaign c $contain", Long::class.javaObjectType);
            val total = createTotalQuery.singleResult

            val createQuery = em.createQuery(query, Campaign::class.java)
            createQuery.firstResult = pageable.offset.toInt()
            createQuery.maxResults = pageable.pageSize
            return PageImpl(createQuery.resultList, pageable,total)
        }

    fun searchV2(
        pageable: Pageable,
        campaignFilterRequestDTO: CampaignFilterV2RequestDTO,
    ) : Page<Campaign>{


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
        // filter 3
        // list add
        val tagIdx : MutableList<Int> = ArrayList()

        if(campaignFilterRequestDTO.tags!!.isNotEmpty()){
            campaignFilterRequestDTO.tags!!.forEach { i ->
                tagIdx.add(i.idx)
            }
        }

        if(tagIdx.isNotEmpty()){
            var tagIdxToString : String = ""
            tagIdxToString = tagIdx.toString().replace("[","(")
            tagIdxToString = tagIdxToString.replace("]",")")
            val tag: String = "c.tag.idx IN $tagIdxToString"
            conditionList.add(tag)
        }

        // filter 4
//        val title = campaignFilterRequestDTO.title
//        var titleFilter : String = ""
//        if(title!=""){
//            titleFilter = "c.campaign.title like '%$title%'"
//            conditionList.add(titleFilter)
//        }
        // list size > 0
        // where 값 + and
        // 마지막만 주의

        if(conditionList.isNotEmpty()){
            condition += "where "
            for(i in 1..conditionList.size){
                if(i==conditionList.size){
                    condition += conditionList[i-1]
                }else{
                    condition += conditionList[i-1]
                    condition += " and "
                }
            }
        }

        val order : String = if(campaignFilterRequestDTO.start == "오래된 순") "desc" else "asc"

        val query = "select distinct c.campaign from CampaignTag c $condition order by c.campaign.startDate $order"


        val createTotalQuery = em.createQuery("select distinct count(c.campaign) from CampaignTag c $condition", Long::class.javaObjectType);
        val total = createTotalQuery.singleResult

        val createQuery = em.createQuery(query, Campaign::class.java)
        createQuery.firstResult = pageable.offset.toInt()
        createQuery.maxResults = pageable.pageSize

        return PageImpl(createQuery.resultList, pageable,total)
    }

    fun searchByTag(
        pageable: Pageable,
        campaignFilterRequestDTO: CampaignFilterV2RequestDTO,
        tagList : MutableList<Int>
    ) : Page<Campaign>{


        var condition = ""

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
        var category = ""
        if(categoryIdx!=0){
            category = "c.campaign.category.idx=$categoryIdx"
            conditionList.add(category)
        }
        // filter 3
        // list add
        val tagIdx : MutableList<Int> = ArrayList()

        if(campaignFilterRequestDTO.tags!!.isNotEmpty()){
            campaignFilterRequestDTO.tags!!.forEach { i ->
                tagIdx.add(i.idx)
            }
        }

        if(tagIdx.isNotEmpty()){
            var tagIdxToString = ""
            tagIdxToString = tagIdx.toString().replace("[","(")
            tagIdxToString = tagIdxToString.replace("]",")")
            val tag = "c.tag.idx IN $tagIdxToString"
            conditionList.add(tag)
        }

        // filter 4
//        val title = campaignFilterRequestDTO.title
//        var titleFilter : String = ""
//        if(title!=""){
//            titleFilter = "c.campaign.title like '%$title%'"
//            conditionList.add(titleFilter)
//        }
        // list size > 0
        // where 값 + and
        // 마지막만 주의
        var tagListToString = ""
        tagListToString = tagList.toString().replace("[","(")
        tagListToString = tagListToString.replace("]",")")


        condition += "where c.tag.idx IN $tagListToString"

        if(conditionList.isNotEmpty()){
            for(i in 1..conditionList.size){
                condition += " and "
                condition += conditionList[i-1]
            }
        }

        val order : String = if(campaignFilterRequestDTO.start == "오래된 순") "desc" else "asc"

        val query = "select distinct c.campaign from CampaignTag c $condition order by c.campaign.startDate $order"


        val createTotalQuery = em.createQuery("select distinct count(c.campaign) from CampaignTag c $condition", Long::class.javaObjectType);
        val total = createTotalQuery.singleResult

        val createQuery = em.createQuery(query, Campaign::class.java)
        createQuery.firstResult = pageable.offset.toInt()
        createQuery.maxResults = pageable.pageSize

        return PageImpl(createQuery.resultList, pageable,total)
    }


    fun searchByCompanyIdx(
        pageable: Pageable,
        companyIdx : Int,
        campaignFilterRequestDTO: CampaignFilterV2RequestDTO,
    ) : Page<Campaign>{


        var condition = ""

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
        var category = ""
        if(categoryIdx!=0){
            category = "c.campaign.category.idx=$categoryIdx"
            conditionList.add(category)
        }
        // filter 3
        // list add
        val tagIdx : MutableList<Int> = ArrayList()

        if(campaignFilterRequestDTO.tags!!.isNotEmpty()){
            campaignFilterRequestDTO.tags!!.forEach { i ->
                tagIdx.add(i.idx)
            }
        }

        if(tagIdx.isNotEmpty()){
            var tagIdxToString = ""
            tagIdxToString = tagIdx.toString().replace("[","(")
            tagIdxToString = tagIdxToString.replace("]",")")
            val tag = "c.tag.idx IN $tagIdxToString"
            conditionList.add(tag)
        }

        condition += "where c.campaign.company.idx = $companyIdx"

        if(conditionList.isNotEmpty()){
            for(i in 1..conditionList.size){
                condition += " and "
                condition += conditionList[i-1]
            }
        }

        val order : String = if(campaignFilterRequestDTO.start == "오래된 순") "desc" else "asc"

        val query = "select distinct c.campaign from CampaignTag c $condition order by c.campaign.startDate $order"


        val createTotalQuery = em.createQuery("select distinct count(c.campaign) from CampaignTag c $condition", Long::class.javaObjectType);
        val total = createTotalQuery.singleResult

        val createQuery = em.createQuery(query, Campaign::class.java)
        createQuery.firstResult = pageable.offset.toInt()
        createQuery.maxResults = pageable.pageSize

        return PageImpl(createQuery.resultList, pageable,total)
    }
}
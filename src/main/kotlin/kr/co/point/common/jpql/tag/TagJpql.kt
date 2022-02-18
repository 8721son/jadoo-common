package kr.co.point.common.jpql.tag

import kr.co.point.common.dto.search.response.PopularTagDTO
import javax.persistence.EntityManager

class TagJpql(private val em: EntityManager) {

//    fun search(
//
//    ) : MutableList<PopularTagDTO>? {
//
//        val subquery = "SELECT tag_idx as idx, count(idx) as cnt from campaign_tag group by tag_idx UNION SELECT tag_idx as idx, count(idx) as cnt from talent_tag group by tag_idx"
//
//        val createSubQuery = em.createQuery(subquery, PopularTagDTO::class.java)
//
//        val query = "SELECT a.idx, SUM(a.cnt) FROM $createSubQuery a group by a.idx"
//
//        val createQuery = em.createQuery(query, PopularTagDTO::class.java)
//
//        return createQuery.resultList
//    }
}
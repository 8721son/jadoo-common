package kr.co.point.common.repository.main

import kr.co.point.common.entity.main.MagazineDetail
import kr.co.point.common.entity.main.MagazineLike
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MagazineLikeRepository : JpaRepository<MagazineLike, Int>
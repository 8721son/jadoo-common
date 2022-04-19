package kr.co.point.common.repository.main

import kr.co.point.common.entity.main.MagazineTag
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MagazineTagRepository : JpaRepository<MagazineTag, Int>
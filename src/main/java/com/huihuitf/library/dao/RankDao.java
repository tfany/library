package com.huihuitf.library.dao;

import com.huihuitf.library.entity.Rank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RankDao extends JpaRepository<Rank,Integer> {
    /**
     * 通过level修改显示名称
     * @param name String类型 修改后的名称
     * @param level Integer 待修改的等级
     * @return 影响行数
     */
    @Modifying
    @Query("update Rank set name=:name where level=:level")
    int updateNameByLevel(@Param("name")String name, @Param("level") Integer level);

    @Modifying
    @Query("update Rank set discount=:discount where level=:level")
    int updateDiscountByLevel(@Param("discount")Double discount, @Param("level") Integer level);


}

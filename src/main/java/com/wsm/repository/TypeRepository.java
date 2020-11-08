package com.wsm.repository;

import com.wsm.entity.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);

    //推荐分类栏
    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
}

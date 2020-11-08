package com.wsm.repository;

import com.wsm.entity.Tag;
import com.wsm.entity.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TagRepository extends JpaRepository<Tag,Long> {


    Tag findByName(String name);

    //推荐标签栏
    @Query("select t from Tag t")
    List<Tag> findTop(Pageable pageable);
}

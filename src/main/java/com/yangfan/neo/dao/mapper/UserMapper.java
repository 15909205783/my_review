package com.yangfan.neo.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yangfan.neo.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> getAll();

    User selectById(@Param("id") Integer id);

    User selectById2();

    User selectByIdOrName(@Param("id") Integer id, @Param("name") String name);

    void setName(Integer id, String name);

    User getOne(Long id);

}

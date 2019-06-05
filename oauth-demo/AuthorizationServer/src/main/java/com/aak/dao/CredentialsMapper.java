package com.aak.dao;


import com.aak.entity.Credentials;
import com.aak.entity.CredentialsExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CredentialsMapper {
    int countByExample(CredentialsExample example);

    int deleteByExample(CredentialsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Credentials record);

    int insertSelective(Credentials record);

    List<Credentials> selectByExample(CredentialsExample example);

    Credentials selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Credentials record, @Param("example") CredentialsExample example);

    int updateByExample(@Param("record") Credentials record, @Param("example") CredentialsExample example);

    int updateByPrimaryKeySelective(Credentials record);

    int updateByPrimaryKey(Credentials record);
}
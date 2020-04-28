package com.vrmine.vrmineproject.mapper;

import com.vrmine.vrmineproject.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Repository
@Mapper
public interface LoginMapper {
    @Select("select adminId,adminName,sex,tel,email from admin where adminId = #{username} and pwd = #{password}")
    public Admin adminLogin(Integer username, String password);
}

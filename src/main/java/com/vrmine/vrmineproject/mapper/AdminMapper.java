package com.vrmine.vrmineproject.mapper;

import com.vrmine.vrmineproject.entity.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("select adminId, adminName,sex,tel,email from admin")
    public List<Admin> findAll();

    @Select("select adminId, adminName,sex,tel,email from admin where adminId = #{adminId}")
    public Admin findById(Integer adminId);

    @Delete("delete from admin where adminId = #{adminId}")
    public int deleteById(int adminId);

    @Update("update admin set pwd = #{pwd} where adminId = #{adminId}")
    int updatePwd(Admin admin);

    @Update("update admin set adminName = #{adminName},sex = #{sex}," +
            "tel = #{tel}, email = #{email},pwd = #{pwd} where adminId = #{adminId}")
    public int update(Admin admin);

    @Options(useGeneratedKeys = true,keyProperty = "adminId")
    @Insert("insert into admin(adminName,sex,tel,email,pwd) " +
            "values(#{adminName},#{sex},#{tel},#{email},#{pwd})")
    public int add(Admin admin);
}

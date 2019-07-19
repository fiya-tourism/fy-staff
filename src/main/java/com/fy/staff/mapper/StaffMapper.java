package com.fy.staff.mapper;

import com.fy.staff.domain.Staff;
import com.fy.staff.domain.StaffSearchVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface StaffMapper {
    int deleteByPrimaryKey(Integer staffId);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(Integer staffId);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);

//    List<Staff> queryStaffList(@Param("sort") String sort,
//                               @Param("order")String order,
//                               @Param("staffSearchVo")StaffSearchVo staffSearchVo);

    void deleteUpdate(Integer staffId);

    List<Staff> getStaffList();

    Staff getStaffByName(String loginName);
}
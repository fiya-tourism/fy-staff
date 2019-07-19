package com.fy.staff.service;

import com.fy.staff.commons.DataGrid;
import com.fy.staff.commons.PageUtil;
import com.fy.staff.domain.Staff;
import com.fy.staff.domain.StaffSearchVo;

import java.util.List;

/**
 * Created by Zy on 2019/7/15.
 */
public interface StaffService {

//    DataGrid queryListStaff(PageUtil pageUtil, StaffSearchVo staffSearchVo);

    String addStaff(Staff staff);
    //逻辑删除
    void deleteUpdate(Integer staffId);
    //修改回显
    Staff updateStaffById(Integer staffId);
    //修改成功
    String updateStaffId(Staff staff);

    List<Staff> getStaffList();
}


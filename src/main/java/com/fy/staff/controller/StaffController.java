package com.fy.staff.controller;

import com.fy.staff.commons.DataGrid;
import com.fy.staff.commons.PageUtil;
import com.fy.staff.domain.Staff;
import com.fy.staff.domain.StaffSearchVo;
import com.fy.staff.service.StaffService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Zy on 2019/7/13.
 */
@Controller
@RequestMapping("staff")
public class StaffController {
    @Autowired
    private StaffService staffService;
    //查询
    @RequestMapping("getStaffList")
    @ResponseBody
    public List<Staff> getStaffList(){
       List<Staff> list = staffService.getStaffList();
        return list;

    }

    @RequestMapping("addStaff")
    @ResponseBody
        public String addStaff(@RequestBody Staff staff){
        return staffService.addStaff(staff);
        }
    //逻辑删除
    @RequestMapping("deleteUpdate")
    @ResponseBody
    public void deleteUpdate(Integer staffId) {
        staffService.deleteUpdate(staffId);
    }
    //修改回显
    @RequestMapping("updateStaffById")
    @ResponseBody
    public Staff updateStaffById(Integer staffId){
        return staffService.updateStaffById(staffId);
    }
    //修改ok
    @RequestMapping("updateStaffId")
    @ResponseBody
    public String updateStaffId(@RequestBody Staff staff){
        return staffService.updateStaffId(staff);
    }

}

package com.fy.staff.service;


import com.fy.staff.commons.DataGrid;
import com.fy.staff.commons.PageUtil;
import com.fy.staff.commons.StrTool;
import com.fy.staff.domain.Staff;
import com.fy.staff.domain.StaffSearchVo;
import com.fy.staff.mapper.StaffMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * Created by Zy on 2019/7/15.
 */
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffMapper staffMapper;

//    @Override
//    public DataGrid queryListStaff(PageUtil pageUtil, StaffSearchVo staffSearchVo) {
//
//        PageHelper.startPage(pageUtil.getPage(),pageUtil.getRows());
//        //驼峰转
//        String sort = StrTool.humpToLine2(pageUtil.getSort());
//        List<Staff> staffList = staffMapper.queryStaffList(sort,pageUtil.getOrder(),staffSearchVo);
//        DataGrid<Staff> dataGrid = new DataGrid<>();
//        PageInfo<Staff> pageInfo = new PageInfo<>(staffList);
//        dataGrid.setRows(staffList);
//        dataGrid.setTotal(pageInfo.getTotal());
//        return dataGrid;
//    }
    //新增
    @Override
    public String addStaff(Staff staff) {
        //状态码  1
        staff.setStaffYn(1);
        //创建时间
        staff.setStaffCreate(new Date());
        //初始密码
        staff.setStaffPass("999");
        //以红色字体打印到控制台
        System.err.println(staff);
        staffMapper.insertSelective(staff);
        return "ok";
    }
    //逻辑删除
    @Override
    public void deleteUpdate(@RequestParam("staffId") Integer staffId) {
        staffMapper.deleteUpdate(staffId);
    }
    //修改回显
    @Override
    public Staff updateStaffById(@RequestParam("staffId") Integer staffId) {
        return staffMapper.selectByPrimaryKey(staffId);
    }
    //修改成功
    @Override
    public String updateStaffId(Staff staff) {
        staffMapper.updateByPrimaryKeySelective(staff);
        return "OJBKupdate";
    }

    @Override
    public List<Staff> getStaffList() {
        List<Staff> list = staffMapper.getStaffList();
        return list;
    }

}

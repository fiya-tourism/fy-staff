package com.fy.login.service;

import com.fy.staff.commons.MD5;
import com.fy.staff.commons.RedisUtil;
import com.fy.staff.commons.ResultVo;
import com.fy.staff.domain.Staff;
import com.fy.staff.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Zy on 2019/7/18.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public ResultVo getLoing(String staffName,String staffPass) {
        ResultVo resultVo = new ResultVo();
        //1.根据name去数据库查询    员工对象
        Staff staff = staffMapper.getStaffByName(staffName);
        //判断staff对象是否存在
        if(staff==null){  //如果不存在
            resultVo.setCode(501);
            resultVo.setMsg("用户名不存在");
            return resultVo;
        }else{
            //判断密码是否一致
            if(!staffPass.equals(staff.getStaffPass())){
           // if(!MD5.md5(staffPass.equals(staff.getStaffPass()))){
                resultVo.setCode(502);
                resultVo.setMsg("密码错误");
                return resultVo;
            }else if(staff.getStaffType()==1110) {
                resultVo.setCode(201);
                resultVo.setMsg("成功");
                //存在redis缓存中
                redisUtil.set("staff",staff);
                return resultVo;
            }else if(staff.getStaffType()==1111) {
                resultVo.setCode(200);
                resultVo.setMsg("管理员成功");
                //存在redis缓存中
                redisUtil.set("staff",staff);
                return resultVo;
            }
        }
        return resultVo;
    }
}

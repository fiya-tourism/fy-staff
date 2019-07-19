package com.fy.login.controller;

import com.fy.login.service.LoginService;
import com.fy.staff.commons.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Zy on 2019/7/18.
 */
@Controller
@RequestMapping("staffLogin")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("login")
    @ResponseBody
    public ResultVo login(HttpServletRequest request, String staffName, String staffPass){
        ResultVo resultVo = loginService.getLoing(staffName,staffPass);
        return resultVo;
    }
}

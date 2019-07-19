package com.fy.login.service;

import com.fy.staff.commons.ResultVo;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Zy on 2019/7/18.
 */
public interface LoginService {

    ResultVo getLoing(String staffName,String staffPass);
}

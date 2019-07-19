package com.fy.staff.commons;


/**
 * 提供返回前台信息
 */

public class ResultVo {
    private Integer code;
    private String  info;
    private String url;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ResultVo() {
    }
    public ResultVo(Integer code, String info) {
        this.code = code;
        this.info = info;
    }
}

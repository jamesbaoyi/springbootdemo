package com.baoyi.springbootdemo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserModel {

    @ApiModelProperty("用戶名")
    private String userName;
    @ApiModelProperty("机构名称")
    private String deptName;

}

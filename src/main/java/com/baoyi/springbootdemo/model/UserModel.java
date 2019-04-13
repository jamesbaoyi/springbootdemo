package com.baoyi.springbootdemo.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserModel implements Serializable {

    @ApiModelProperty("用戶名")
    private String userName;
    @ApiModelProperty("机构名称")
    private String deptName;

}

package com.bruce121.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: Bruce121
 * Date: 2018-10-31
 */
@Setter
@Getter
// @ApiModel 描述类的作用
@ApiModel(value = "User", description = "用户信息")
public class User implements Serializable{
    private static final long serialVersionUID = 4884085122098718957L;

    // @ApiModelProperty 描述字段的含义，展示样例的值
    @ApiModelProperty(name = "id", value = "用户ID", example = "1")
    private Long id;
    @ApiModelProperty(name = "name", value = "用户姓名", example = "smallDragon")
    private String name;
    @ApiModelProperty(name = "age", value = "用户年龄", example = "20")
    private Integer age;
    @ApiModelProperty(value = "创建时间", example = "2018-10-31 14:51:18.0")
    private String createTime;
    @ApiModelProperty(value = "更新时间", example = "2018-10-31 14:53:23.0")
    private String updateTime;
}
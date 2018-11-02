package com.bruce121.entity;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Author: Bruce121
 * Date: 2018-10-31
 */
@Setter
@Getter
public class User implements Serializable{
    private static final long serialVersionUID = 4884085122098718957L;
    private Long id;
    private String name;
    private Integer age;
    private String createTime;
    private String updateTime;
}

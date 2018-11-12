package com.bruce121.controller;

import com.bruce121.entity.User;
import com.bruce121.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Author: Bruce121
 * Date: 2018-10-31
 */
// @Api 修饰整个类，描述Controller的作用
@Api(value = "user-controller", description = "用户操作")
@RestController
public class UserController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    private UserService userService;

    // @ApiOperation 修饰方法，描述method作用
    @ApiOperation(value = "Save User 保存用户", response = String.class, httpMethod = "POST")
    // @ApiImplicitParams 修饰方法，添加隐含的请求参数（例如：请求头中的内容）
    @ApiImplicitParams({
            // 任何需要隐含添加的参数都可以在这里添加，这样依赖通过swagger-ui的文档就可以传入这个参数，
            // 如果参数栏里不存在并且不再这里指定的话，无法通过swagger-ui的文档传入该参数
            @ApiImplicitParam(name = "Authorization", required = true, value = "Bearer xxxx", paramType = "header"),
    })
    @RequestMapping(path = "/user", method = {RequestMethod.POST})
    public String saveUser(@RequestBody User user){
        return userService.save(user) ? SUCCESS : FAIL;
    }

    @ApiOperation(value = "Get User by ID 根据ID查询用户.", response = User.class, httpMethod = "GET")
    @RequestMapping(path = "/user/{id}", method = {RequestMethod.GET})
    public User getByJdbc(@PathVariable("id")long id){
        return userService.get(id);
    }

    @ApiIgnore
    @RequestMapping(path = "/get/{id}", method = {RequestMethod.GET})
    public User getById(@PathVariable("id") long id){
        return userService.getByOriginal(id);
    }

    @ApiOperation(value = "Update User 更新用户", response = String.class, httpMethod = "PUT")
    @RequestMapping(path = "/user", method = {RequestMethod.PUT})
    public String updateUser(@RequestBody User user){
        return userService.update(user) ? SUCCESS : FAIL;
    }

    @ApiOperation(value = "Delete User 删除用户", response = String.class, httpMethod = "DELETE")
    @RequestMapping(path = "/user/{id}", method = {RequestMethod.DELETE})
    public String deleteUser(@PathVariable Long id){
        return userService.delete(id) ? SUCCESS : FAIL;
    }

}
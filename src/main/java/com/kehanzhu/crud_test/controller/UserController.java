package com.kehanzhu.crud_test.controller;

import com.kehanzhu.crud_test.pojo.ResponseMessage;
import com.kehanzhu.crud_test.pojo.User;
import com.kehanzhu.crud_test.pojo.dto.UserDto;
import com.kehanzhu.crud_test.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController //接口方法返回对象 转换成json文本
@RequestMapping("/user") //localhost:8090/user/**
public class UserController {

    @Autowired
    private IUserService userService;

    // 增加
    @PostMapping // URL:localhost:8090/user/ method:post
    public ResponseMessage<User> add(@RequestBody UserDto user) {
        User userNew = userService.add(user);
        return ResponseMessage.success(userNew);
    }

    // 查询
    @GetMapping("/{userId}") // URL:localhost:8090/user/1 method:get
    public ResponseMessage<User> get(@PathVariable("userId") Integer userId) {
        User userNew = userService.getUser(userId);
        return ResponseMessage.success(userNew);
    }

    // 修改
    @PutMapping
    public ResponseMessage<User> update(@RequestBody UserDto user) {
        User userNew = userService.update(user);
        return ResponseMessage.success(userNew);
    }

    // 删除
    @DeleteMapping("/{userId}")
    public ResponseMessage<User> delete(@PathVariable("userId") Integer userId) {
        userService.delete(userId);
        return ResponseMessage.success();
    }
}

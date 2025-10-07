package com.kehanzhu.crud_test.service;

import com.kehanzhu.crud_test.pojo.User;
import com.kehanzhu.crud_test.pojo.dto.UserDto;

public interface IUserService {
    /**
     * 插入用户
     *
     * @param user 参数
     * @return user对象
     */
    User add(UserDto user);

    /**
     * 查询用户
     * @param userId 用户id
     * @return
     */
    User getUser(Integer userId);

    /**
     * 修改用户
     * @param user 修改用户对象
     * @return
     */
    User update(UserDto user);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    void delete(Integer userId);
}

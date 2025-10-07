package com.kehanzhu.crud_test.service;

import com.kehanzhu.crud_test.pojo.User;
import com.kehanzhu.crud_test.pojo.dto.UserDto;
import com.kehanzhu.crud_test.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //spring的bean
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User add(UserDto user) {
        User userPojo = new User();
        BeanUtils.copyProperties(user, userPojo);
        return userRepository.save(userPojo);
    }

    @Override
    public User getUser(Integer userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("用户不存在，参数异常"));
    }

     @Override
    public User update(UserDto user) {
        // 首先检查用户是否存在
        User existingUser = userRepository.findById(user.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("要更新的用户不存在，参数异常"));
        
        // 将DTO的属性复制到已存在的用户对象上，保留原有ID
        BeanUtils.copyProperties(user, existingUser);
        
        // 保存更新后的用户
        return userRepository.save(existingUser);
    }

    @Override
    public void delete(Integer userId) {
        userRepository.deleteById(userId);
    }
}

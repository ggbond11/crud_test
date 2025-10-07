package com.kehanzhu.crud_test.repository;

import com.kehanzhu.crud_test.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}

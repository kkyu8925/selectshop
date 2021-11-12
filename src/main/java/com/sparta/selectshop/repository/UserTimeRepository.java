package com.sparta.selectshop.repository;

import com.sparta.selectshop.model.User;
import com.sparta.selectshop.model.UserTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTimeRepository extends JpaRepository<UserTime, Long> {
    UserTime findByUser(User user);
}

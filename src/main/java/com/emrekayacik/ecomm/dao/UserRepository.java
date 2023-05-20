package com.emrekayacik.ecomm.dao;

import com.emrekayacik.ecomm.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository  extends JpaRepository<User, Long> {
    User getUserByUsername(String username);
    User getUserByPhoneNumberOrEmail(String phoneNumber, String email);
    @Transactional
    void deleteUserByUsernameAndPhoneNumber(String username, String phoneNumber);
}

package com.emrekayacik.ecomm.service;

import com.emrekayacik.ecomm.base.service.BaseEntityService;
import com.emrekayacik.ecomm.dao.UserRepository;
import com.emrekayacik.ecomm.domain.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseEntityService<User, UserRepository> {
    UserRepository repository;
    public UserService(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public User getByUsername(String username){
        return repository.getUserByUsername(username);
    }
    public void deleteUserByUsernameAndPhoneNumber(String username, String phoneNumber){
        repository.deleteUserByUsernameAndPhoneNumber(username,phoneNumber);
    }
    public User getUserByPhoneNumberOrEmail(String phoneNumber, String email){
        return repository.getUserByPhoneNumberOrEmail(phoneNumber,email);
    }
}

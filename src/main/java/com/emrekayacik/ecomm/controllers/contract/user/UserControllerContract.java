package com.emrekayacik.ecomm.controllers.contract.user;

import com.emrekayacik.ecomm.controllers.contract.BaseControllerContract;
import com.emrekayacik.ecomm.domain.dto.UserDto;
import com.emrekayacik.ecomm.domain.request.UserLoginRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserControllerContract extends BaseControllerContract<UserDto> {
    UserDto getByUsername(String username);
    void deleteUserByUsernameAndPhoneNumber(String username, String phoneNumber);
    boolean login(UserLoginRequest request);
}

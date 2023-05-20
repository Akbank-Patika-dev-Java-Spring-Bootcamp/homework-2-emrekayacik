package com.emrekayacik.ecomm.controllers.contract.user;

import com.emrekayacik.ecomm.base.exception.custom.ItemNotFoundException;
import com.emrekayacik.ecomm.domain.dto.UserDto;
import com.emrekayacik.ecomm.domain.entity.User;
import com.emrekayacik.ecomm.domain.request.UserLoginRequest;
import com.emrekayacik.ecomm.infrastructure.mapper.UserMapper;
import com.emrekayacik.ecomm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserControllerContractImpl implements UserControllerContract{
    private final UserService userService;
    private UserMapper INSTANCE = getMapper();
    private final BCryptPasswordEncoder passwordEncoder;
    @Override
    public UserDto save(UserDto DTO) {
        User userFound = userService.getUserByPhoneNumberOrEmail(DTO.phoneNumber(), DTO.email());
        if(userFound != null){
            throw new ItemNotFoundException(() ->
                "Phone number or email is already taken by another user!"
            );
        }

        String hashedPassword = passwordEncoder.encode(DTO.password());

        User userEntity = INSTANCE.convertToEntity(DTO);
        userEntity.setPassword(hashedPassword);
        User user = userService.save(userEntity);

        return INSTANCE.convertToDto(user);
    }

    @Override
    public List<UserDto> findAll() {
        return INSTANCE.convertToDtoList(userService.findAll());
    }

    @Override
    public void delete(Long id) {
        userService.delete(id);
    }

    @Override
    public UserDto findById(Long id) {
        return INSTANCE.convertToDto(userService.findById(id).orElseThrow(() -> new IllegalArgumentException("User with the id: " + id + " not found")));
    }

    @Override
    public UserDto update(UserDto userDto) {
        return INSTANCE.convertToDto(userService.save(INSTANCE.convertToEntity(userDto)));
    }

    @Override
    public UserDto getByUsername(String username) {
        return INSTANCE.convertToDto(userService.getByUsername(username));
    }

    @Override
    public void deleteUserByUsernameAndPhoneNumber(String username, String phoneNumber) {
        User user = userService.getByUsername(username);
        if(user == null){
            throw new ItemNotFoundException(() -> "The user cannot be found by username");
        }
        if(!(user.getUsername().equals(username) && user.getPhoneNumber().equals(phoneNumber))){
            throw new ItemNotFoundException(() ->"The username " + username + " and the phone number " + phoneNumber + " does not match!");
        }
        userService.deleteUserByUsernameAndPhoneNumber(username,phoneNumber);
    }

    //TODO: JWT
    @Override
    public boolean login(UserLoginRequest request) {
        String storedHashedPassword = userService.getByUsername(request.username()).getPassword();
        boolean passwordMatches = passwordEncoder.matches(request.password(), storedHashedPassword);

        return passwordMatches;
    }

    private UserMapper getMapper(){
        return Mappers.getMapper(UserMapper.class);
    }

}

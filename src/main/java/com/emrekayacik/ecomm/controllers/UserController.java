package com.emrekayacik.ecomm.controllers;

import com.emrekayacik.ecomm.base.response.RestResponse;
import com.emrekayacik.ecomm.controllers.contract.user.UserControllerContract;
import com.emrekayacik.ecomm.domain.dto.UserDto;
import com.emrekayacik.ecomm.domain.request.UserDeleteRequest;
import com.emrekayacik.ecomm.domain.request.UserLoginRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@Validated
@RequiredArgsConstructor
public class UserController extends BaseController {
    private final UserControllerContract userControllerContract;

    @GetMapping("/")
    public ResponseEntity<RestResponse<List<UserDto>>> get(){
        return genericReturnOk(userControllerContract.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<UserDto>> findById(@PathVariable Long id){
        return genericReturnOk(userControllerContract.findById(id));
    }
    @GetMapping("/user")
    public ResponseEntity<RestResponse<UserDto>> findByUsername(@RequestParam @Valid @NotBlank String username){
        return genericReturnOk(userControllerContract.getByUsername(username));
    }
    @PostMapping("/")
    public ResponseEntity<RestResponse<UserDto>> save(@RequestBody @Valid UserDto userDto){
        return genericReturnOk(userControllerContract.save(userDto));
    }
    @DeleteMapping("/")
    public ResponseEntity<RestResponse<Object>> delete(@RequestBody @Valid UserDeleteRequest request){
        userControllerContract.deleteUserByUsernameAndPhoneNumber(request.username(), request.phoneNumber());
        return genericReturnEmpty();
    }
    @PutMapping("/")
    public ResponseEntity<RestResponse<UserDto>> update(@Valid @RequestBody UserDto userDto){
        return genericReturnOk(userControllerContract.update(userDto));
    }
    @PostMapping("/login")
    public ResponseEntity<RestResponse<Boolean>> login(@RequestBody UserLoginRequest request){
        return genericReturnOk(userControllerContract.login(request));
    }
}

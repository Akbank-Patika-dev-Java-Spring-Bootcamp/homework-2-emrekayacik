package com.emrekayacik.ecomm.domain.dto;

import com.emrekayacik.ecomm.base.dto.BaseDto;
import com.emrekayacik.ecomm.domain.enums.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record UserDto(Long id, @NotBlank @Length(min = 3,max = 25) String username,
                      @NotBlank @Length(min = 3,max = 25)String password,
                      @NotBlank @Length(min = 2,max = 50)String name,
                      @NotBlank @Length(min = 2,max = 50) String surname,
                      LocalDate birthDate,
                      UserType type,
                      @Email String email,
                      @Length(min = 3,max = 250)String address,
                      @NotBlank @Length(min = 3,max = 30)String phoneNumber) implements BaseDto {
    @Override
    public Long getId() {
        return id();
    }
}

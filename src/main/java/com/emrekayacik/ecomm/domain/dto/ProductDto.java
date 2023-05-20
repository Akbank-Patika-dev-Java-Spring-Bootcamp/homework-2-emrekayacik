package com.emrekayacik.ecomm.domain.dto;

import com.emrekayacik.ecomm.base.dto.BaseDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record ProductDto(
        Long id,
        @NotBlank(message = "Name cannot be blank") @Length(min = 3,max = 70,message = "Name length must be between 3-70 characters long") String name,
        @Length(min = 3,max = 250,message = "Description length must be between 3-250 characters long") String description,
        @NotNull(message = "Price cannot be null") @Positive(message = "Price must be greater than 0") double price) implements BaseDto {
    @Override
    public Long getId() {
        return id();
    }
}

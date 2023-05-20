package com.emrekayacik.ecomm.domain.request;

import jakarta.validation.constraints.NotBlank;

public record UserDeleteRequest (@NotBlank String username, @NotBlank String phoneNumber) {
}

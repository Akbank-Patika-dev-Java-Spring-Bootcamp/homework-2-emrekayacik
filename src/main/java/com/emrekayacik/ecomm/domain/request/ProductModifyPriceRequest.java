package com.emrekayacik.ecomm.domain.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductModifyPriceRequest(@NotNull @Positive double price) {
}

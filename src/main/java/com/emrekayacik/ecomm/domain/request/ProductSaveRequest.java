package com.emrekayacik.ecomm.domain.request;


public record ProductSaveRequest(Long id, String name, String description, double price) {
}

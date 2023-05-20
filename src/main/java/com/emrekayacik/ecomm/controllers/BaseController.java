package com.emrekayacik.ecomm.controllers;

import com.emrekayacik.ecomm.base.response.RestResponse;
import org.springframework.http.ResponseEntity;


public class BaseController {
    public <T> ResponseEntity<RestResponse<T>> genericReturnOk(T object){
        return ResponseEntity.ok(RestResponse.of(object));
    }
    public ResponseEntity<RestResponse<Object>> genericReturnEmpty(){
        return ResponseEntity.ok(RestResponse.empty());
    }
}

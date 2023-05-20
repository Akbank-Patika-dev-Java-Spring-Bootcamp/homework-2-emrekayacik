package com.emrekayacik.ecomm.controllers;

import com.emrekayacik.ecomm.base.response.RestResponse;
import com.emrekayacik.ecomm.controllers.contract.product.ProductControllerContract;
import com.emrekayacik.ecomm.domain.dto.ProductDto;
import com.emrekayacik.ecomm.domain.entity.Product;
import com.emrekayacik.ecomm.domain.request.ProductModifyPriceRequest;
import com.emrekayacik.ecomm.domain.request.ProductSaveRequest;
import com.emrekayacik.ecomm.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
@Validated
public class ProductController extends BaseController {

    private final ProductControllerContract productControllerContract;

    @GetMapping("/")
    public ResponseEntity<RestResponse<List<ProductDto>>> get(){
        return genericReturnOk(productControllerContract.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<ProductDto>> findById(@PathVariable Long id){
        return genericReturnOk(productControllerContract.findById(id));
    }
    @PostMapping("/")
    public ResponseEntity<RestResponse<ProductDto>> save(@RequestBody @Valid ProductDto productDto){
        ProductDto productDtoResponse = productControllerContract.save(productDto);
        return genericReturnOk(productDtoResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id){
        productControllerContract.delete(id);
        return genericReturnEmpty();
    }
    @PatchMapping("/{id}/modify-price")
    public ResponseEntity<RestResponse<Object>> modifyPrice(@PathVariable Long id,  @Valid @RequestBody ProductModifyPriceRequest request){
        productControllerContract.modifyPriceById(id,request.price());
        return genericReturnEmpty();
    }
}

package com.emrekayacik.ecomm.controllers.contract.product;

import com.emrekayacik.ecomm.domain.dto.ProductDto;
import com.emrekayacik.ecomm.domain.entity.Product;
import com.emrekayacik.ecomm.domain.request.ProductSaveRequest;
import com.emrekayacik.ecomm.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import com.emrekayacik.ecomm.infrastructure.mapper.ProductMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductControllerContractImpl implements ProductControllerContract {

    private final ProductService productService;
    private ProductMapper INSTANCE = getMapper();

    @Override
    public ProductDto save(ProductDto DTO) {

        Product product = INSTANCE.convertToEntity(DTO);

        product = productService.save(product);

        return INSTANCE.convertToDto(product);
    }

    @Override
    public List<ProductDto> findAll() {
        List<Product> productList = productService.findAll();
        return INSTANCE.convertToDtoList(productList);
    }

    @Override
    public void delete(Long id) {
        productService.delete(id);
    }

    @Override
    public ProductDto findById(Long id) {
        return INSTANCE.convertToDto(productService.findById(id).orElse(null));
    }

    @Override
    public ProductDto update(ProductDto userDto) {
        return INSTANCE.convertToDto(productService.save(INSTANCE.convertToEntity(userDto)));
    }

    @Override
    public void modifyPriceById(Long id, double price) {
        productService.updateProductPriceById(id,price);
    }

    private ProductMapper getMapper(){
        return Mappers.getMapper(ProductMapper.class);
    }
}
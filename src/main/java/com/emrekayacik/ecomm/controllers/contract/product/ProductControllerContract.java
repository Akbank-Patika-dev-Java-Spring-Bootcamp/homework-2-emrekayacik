package com.emrekayacik.ecomm.controllers.contract.product;

import com.emrekayacik.ecomm.controllers.contract.BaseControllerContract;
import com.emrekayacik.ecomm.domain.dto.ProductDto;
import com.emrekayacik.ecomm.domain.dto.UserDto;
import com.emrekayacik.ecomm.domain.request.ProductSaveRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductControllerContract extends BaseControllerContract<ProductDto> {
    void modifyPriceById(Long id, double price);
}

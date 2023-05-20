package com.emrekayacik.ecomm.infrastructure.mapper;

import com.emrekayacik.ecomm.base.mapper.BaseMapper;
import com.emrekayacik.ecomm.domain.dto.ProductDto;
import com.emrekayacik.ecomm.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper extends BaseMapper<Product, ProductDto> {
}

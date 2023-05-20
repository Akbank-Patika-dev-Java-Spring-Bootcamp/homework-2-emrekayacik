package com.emrekayacik.ecomm.base.mapper;

import com.emrekayacik.ecomm.base.dto.BaseDto;
import com.emrekayacik.ecomm.base.entity.BaseEntity;
import com.emrekayacik.ecomm.domain.dto.ProductDto;
import com.emrekayacik.ecomm.domain.entity.Product;
import com.emrekayacik.ecomm.infrastructure.mapper.ProductMapper;
import jakarta.persistence.MappedSuperclass;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@MappedSuperclass
public interface BaseMapper<E extends BaseEntity, D extends BaseDto> {

    E convertToEntity(D productDto);

    D convertToDto(E product);

    List<D> convertToDtoList(List<E> entityList);
    List<E> convertToEntityList(List<D> dtoList);
}

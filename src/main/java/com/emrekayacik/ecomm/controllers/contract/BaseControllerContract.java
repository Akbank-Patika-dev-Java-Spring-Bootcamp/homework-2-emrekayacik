package com.emrekayacik.ecomm.controllers.contract;

import com.emrekayacik.ecomm.base.dto.BaseDto;
import com.emrekayacik.ecomm.domain.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseControllerContract<D extends BaseDto> {
    D save(D DTO);

    List<D> findAll();

    void delete(Long id);
    D findById(Long id);
    D update(D userDto);
}

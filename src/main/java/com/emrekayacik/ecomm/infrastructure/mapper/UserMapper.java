package com.emrekayacik.ecomm.infrastructure.mapper;

import com.emrekayacik.ecomm.base.mapper.BaseMapper;
import com.emrekayacik.ecomm.domain.dto.UserDto;
import com.emrekayacik.ecomm.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends BaseMapper<User, UserDto> {
}

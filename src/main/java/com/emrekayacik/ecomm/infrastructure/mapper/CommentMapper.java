package com.emrekayacik.ecomm.infrastructure.mapper;

import com.emrekayacik.ecomm.base.mapper.BaseMapper;
import com.emrekayacik.ecomm.domain.dto.CommentDto;
import com.emrekayacik.ecomm.domain.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper extends BaseMapper<Comment, CommentDto> {

}
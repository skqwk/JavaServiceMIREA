package com.mirea.demo.mapper;

import com.mirea.demo.model.dto.*;
import com.mirea.demo.model.entity.RequestEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface RequestMapper {
    RequestEntity dtoToEntity(NewRequestDTO newRequestDTO);

    CreatedRequestDTO entityToCreatedDto(RequestEntity requestEntity);

    RequestDTO entityToDto(RequestEntity requestEntity);

    RequestEntity freshDTOToEntity(FreshRequestDTO freshRequestDTO);

    UpdatedRequestDTO entityToUpdatedDto(RequestEntity requestEntity);
}

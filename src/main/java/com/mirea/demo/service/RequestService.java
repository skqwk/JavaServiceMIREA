package com.mirea.demo.service;

import com.mirea.demo.dao.RequestRepository;
import com.mirea.demo.exception.RequestNotFoundException;
import com.mirea.demo.mapper.RequestMapper;
import com.mirea.demo.model.dto.*;
import com.mirea.demo.model.entity.RequestEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RequestService {
    private RequestRepository requestRepository;
    private RequestMapper requestMapper;

    public CreatedRequestDTO createRequest(NewRequestDTO newRequestDTO) {
        RequestEntity save = requestRepository.save(requestMapper.dtoToEntity(newRequestDTO));
        return requestMapper.entityToCreatedDto(save);

    }

    public RequestDTO getRequest(Long id) {
        RequestEntity requestEntity = requestRepository.findById(id).orElseThrow(() -> new RequestNotFoundException(id));
        return requestMapper.entityToDto(requestEntity);

    }

    public void deleteRequest(Long id) {
        requestRepository.findById(id).orElseThrow(() -> new RequestNotFoundException(id));
        requestRepository.deleteById(id);
    }

    public UpdatedRequestDTO updateRequest(Long id, FreshRequestDTO freshRequestDTO) {
        requestRepository.findById(id).orElseThrow(() -> new RequestNotFoundException(id));

        RequestEntity freshEntity = requestMapper.freshDTOToEntity(freshRequestDTO);
        freshEntity.setId(id);

        return requestMapper.entityToUpdatedDto(requestRepository.save(freshEntity));
    }
}

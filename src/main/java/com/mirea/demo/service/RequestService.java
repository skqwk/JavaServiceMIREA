package com.mirea.demo.service;

import com.mirea.demo.dao.RequestRepository;
import com.mirea.demo.exception.RequestNotFoundException;
import com.mirea.demo.mapper.RequestMapper;
import com.mirea.demo.model.dto.CreatedRequestDTO;
import com.mirea.demo.model.dto.NewRequestDTO;
import com.mirea.demo.model.dto.RequestDTO;
import com.mirea.demo.model.entity.RequestEntity;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
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

    public boolean deleteRequest(Long id) {
        try {
            requestRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            throw new RequestNotFoundException(id);
        }
    }

    public CreatedRequestDTO updateRequest(Long id, NewRequestDTO updatedRequestDTO) {
        RequestEntity requestEntity = requestRepository.findById(id).orElseThrow(() -> new RequestNotFoundException(id));
        requestEntity.setAmount(updatedRequestDTO.getAmount());
        requestEntity.setDescription(updatedRequestDTO.getDescription());
        requestEntity.setName(updatedRequestDTO.getName());

        RequestEntity save = requestRepository.save(requestEntity);

        return requestMapper.entityToCreatedDto(save);
    }
}

package com.ecoprojectsfinal.services.oganizationServices;

import com.ecoprojectsfinal.dtos.organizationsDto.OrganizationRequestDto;
import com.ecoprojectsfinal.dtos.organizationsDto.OrganizationResponseDto;

import java.util.List;

public interface OrganizationService {
    List<OrganizationResponseDto> findAll();
    OrganizationResponseDto findById(Long id);
    OrganizationResponseDto create(OrganizationRequestDto dto);
    OrganizationResponseDto update(Long id, OrganizationRequestDto dto);
    void delete(Long id);
}
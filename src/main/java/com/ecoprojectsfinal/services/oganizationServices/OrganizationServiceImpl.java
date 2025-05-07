package com.ecoprojectsfinal.services.oganizationServices;


import com.ecoprojectsfinal.dtos.organizationsDto.OrganizationRequestDto;
import com.ecoprojectsfinal.dtos.organizationsDto.OrganizationResponseDto;
import com.ecoprojectsfinal.entities.Organization;
import com.ecoprojectsfinal.repositories.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository repository;

    @Override
    public List<OrganizationResponseDto> findAll() {
        return repository.findAll().stream().map(
                o -> OrganizationResponseDto.builder()
                        .id(o.getId())
                        .name(o.getName())
                        .contact(o.getContact())
                        .build()
        ).toList();
    }

    @Override
    public OrganizationResponseDto findById(Long id) {
        Organization org = repository.findById(id).orElseThrow();
        return OrganizationResponseDto.builder()
                .id(org.getId())
                .name(org.getName())
                .contact(org.getContact())
                .build();
    }

    @Override
    public OrganizationResponseDto create(OrganizationRequestDto dto) {
        Organization org = new Organization();
        org.setName(dto.getName());
        org.setContact(dto.getContact());
        return toDto(repository.save(org));
    }

    @Override
    public OrganizationResponseDto update(Long id, OrganizationRequestDto dto) {
        Organization org = repository.findById(id).orElseThrow();
        org.setName(dto.getName());
        org.setContact(dto.getContact());
        return toDto(repository.save(org));
    }

    @Override
    public void delete(Long id) {
        repository.findById(id).orElseThrow();
        repository.deleteById(id);
    }

    private OrganizationResponseDto toDto(Organization org) {
        return OrganizationResponseDto.builder()
                .id(org.getId())
                .name(org.getName())
                .contact(org.getContact())
                .build();
    }
}
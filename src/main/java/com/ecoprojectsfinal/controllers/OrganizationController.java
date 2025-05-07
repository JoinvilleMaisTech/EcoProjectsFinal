package com.ecoprojectsfinal.controllers;

import com.ecoprojectsfinal.dtos.organizationsDto.OrganizationRequestDto;
import com.ecoprojectsfinal.dtos.organizationsDto.OrganizationResponseDto;
import com.ecoprojectsfinal.services.oganizationServices.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("organizations")
public class OrganizationController {

    private final OrganizationService service;

    @GetMapping
    public List<OrganizationResponseDto> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public OrganizationResponseDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrganizationResponseDto create(@RequestBody OrganizationRequestDto dto) {
        return service.create(dto);
    }

    @PutMapping("{id}")
    public OrganizationResponseDto update(@PathVariable Long id, @RequestBody OrganizationRequestDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
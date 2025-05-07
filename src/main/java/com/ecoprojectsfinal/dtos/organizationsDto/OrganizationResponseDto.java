package com.ecoprojectsfinal.dtos.organizationsDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrganizationResponseDto {
    private Long id;
    private String name;
    private String contact;
}

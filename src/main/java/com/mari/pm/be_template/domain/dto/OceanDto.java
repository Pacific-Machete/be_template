package com.mari.pm.be_template.domain.dto;

import com.mari.pm.be_template.domain.entity.Ocean;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OceanDto {
    private String name;
    private boolean visited;

    public void whenVisited(){
        visited = true;
    }
    public static OceanDto of(Ocean ocean) {
        return OceanDto.builder()
                .name(ocean.getName())
                .visited(ocean.isVisited())
                .build();
    }

    public Ocean toEntity() {
        return Ocean.builder()
                .name(getName())
                .visited(isVisited())
                .build();
    }
}

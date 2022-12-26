package com.mari.pm.be_template.domain.service;

import com.mari.pm.be_template.domain.dto.OceanDto;
import com.mari.pm.be_template.domain.entity.Ocean;
import com.mari.pm.be_template.domain.exception.NoOceanException;
import com.mari.pm.be_template.domain.repository.BaseOceanRepository;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional()
public class OceanService {

    private final BaseOceanRepository oceanRepository;

    @Transactional(readOnly = true)
    public OceanDto getOcean(long id) {
        Ocean findOcean = oceanRepository.getOcean(id);
        if (findOcean == null) {
            throw new NoOceanException(id);
        }
        return OceanDto.of(findOcean);
    }

    @Transactional(readOnly = true)
    public List<OceanDto> allOcean() {
        return oceanRepository.allOcean().stream()
                .map(OceanDto::of)
                .collect(Collectors.toList());
    }

    public OceanDto updateOcean(OceanDto oceanDto) {
        Ocean updateOcean = oceanRepository.updateOcean(oceanDto.toEntity());
        return OceanDto.of(updateOcean);
    }
}

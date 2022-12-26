package com.mari.pm.be_template.domain.service;

import com.mari.pm.be_template.domain.dto.OceanDto;
import com.mari.pm.be_template.domain.entity.Ocean;
import com.mari.pm.be_template.domain.repository.OceanJpaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OceanServiceTest {

    @Autowired
    OceanService oceanService;


    @Autowired
    OceanJpaRepository oceanJpaRepository;

    @AfterEach
    void tearDown() {
        oceanJpaRepository.deleteAll();
    }

    @Test
    void createOceanTest() {
        oceanJpaRepository.save(Ocean.builder().name("Pacific").build());

        List<OceanDto> oceanDtoList = oceanService.allOcean();

        assertThat(oceanDtoList).isNotEmpty();
        assertThat(oceanDtoList.get(0).getName()).isEqualTo("Pacific");
    }

    @Test
    void searchOceanTest() {
        Ocean savedOcean = oceanJpaRepository.save(Ocean.builder().name("Pacific").build());

        OceanDto findOcean = oceanService.getOcean(savedOcean.getId());

        assertThat(findOcean).isNotNull();
        assertThat(findOcean.getName()).isEqualTo("Pacific");
    }

    @Test
    void getAllOceanTest() {
        oceanJpaRepository.save(Ocean.builder().name("Pacific").build());
        oceanJpaRepository.save(Ocean.builder().name("Atlantic").build());
        oceanJpaRepository.save(Ocean.builder().name("Indian").build());

        List<OceanDto> oceanDtoList = oceanService.allOcean();

        assertThat(oceanDtoList).hasSize(3);
    }

    @Test
    void updateOceanTest() {
        Ocean savedOcean = oceanJpaRepository.save(Ocean.builder().name("Pacific").build());
        OceanDto oceanDto = OceanDto.of(savedOcean);
        oceanDto.whenVisited();

        OceanDto updateOcean = oceanService.updateOcean(oceanDto);

        assertThat(updateOcean).isNotNull();
        assertThat(updateOcean.isVisited()).isTrue();
    }
}
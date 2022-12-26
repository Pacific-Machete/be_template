package com.mari.pm.be_template.domain.repository;

import com.mari.pm.be_template.domain.entity.Ocean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OceanRepository implements BaseOceanRepository {

    private final OceanJpaRepository oceanJpaRepository;

    @Override
    public Ocean getOcean(long id) {
        return oceanJpaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Ocean> allOcean() {
        return oceanJpaRepository.findAll();
    }

    @Override
    public Ocean updateOcean(Ocean ocean) {
        return oceanJpaRepository.save(ocean);
    }
}

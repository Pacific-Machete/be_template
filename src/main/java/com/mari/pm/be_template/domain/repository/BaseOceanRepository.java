package com.mari.pm.be_template.domain.repository;

import com.mari.pm.be_template.domain.entity.Ocean;

import java.util.List;

public interface BaseOceanRepository {

    Ocean getOcean(long id);

    List<Ocean> allOcean();

    Ocean updateOcean(Ocean ocean);
}

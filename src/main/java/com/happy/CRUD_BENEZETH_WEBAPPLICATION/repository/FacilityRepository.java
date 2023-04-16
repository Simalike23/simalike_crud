package com.happy.CRUD_BENEZETH_WEBAPPLICATION.repository;

import com.happy.CRUD_BENEZETH_WEBAPPLICATION.entity.FacilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<FacilityEntity, Long> {
    //CRUD Methods for database
}

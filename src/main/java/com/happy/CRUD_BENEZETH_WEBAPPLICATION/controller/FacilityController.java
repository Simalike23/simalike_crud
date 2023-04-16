package com.happy.CRUD_BENEZETH_WEBAPPLICATION.controller;

import com.happy.CRUD_BENEZETH_WEBAPPLICATION.entity.FacilityEntity;
import com.happy.CRUD_BENEZETH_WEBAPPLICATION.exception.FacilityException;
import com.happy.CRUD_BENEZETH_WEBAPPLICATION.repository.FacilityRepository;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/facility_Info")
public class FacilityController {

    @Autowired
    private FacilityRepository facilityRepository;

    //code for getting all facility
    @GetMapping
    public List<FacilityEntity> getAllFacility(){
        return facilityRepository.findAll();
    }

    //code for creating facility
    @PostMapping
    public FacilityEntity createFacility(@RequestBody FacilityEntity facilityEntity){
        return facilityRepository.save(facilityEntity);
    }

    //Code for getting facility by Id
    @GetMapping("{id}")
    public ResponseEntity<FacilityEntity> getFacilityById(@PathVariable long id){
        FacilityEntity getFacility = facilityRepository.findById(id)
                .orElseThrow(()->new FacilityException("Facility not Found, " +
                        "Please Look your id"));
        return ResponseEntity.ok(getFacility);
    }

    //Code for updating facility
    @PutMapping("{id}")
    public ResponseEntity<FacilityEntity> updateFacility(@PathVariable long id,@RequestBody FacilityEntity facilityEntityDetails){
        FacilityEntity updateFacility = facilityRepository.findById(id)
                .orElseThrow(()->new FacilityException("Facility Not found"));

        updateFacility.setFacilityId(facilityEntityDetails.getFacilityId());
        updateFacility.setFacilityName(facilityEntityDetails.getFacilityName());
        updateFacility.setFacilityContact(facilityEntityDetails.getFacilityContact());
        updateFacility.setFacilityLocation(facilityEntityDetails.getFacilityLocation());
        updateFacility.setFacilityWebsite(facilityEntityDetails.getFacilityWebsite());
        updateFacility.setFacilityCapacity(facilityEntityDetails.getFacilityCapacity());

        facilityRepository.save(updateFacility);

        return ResponseEntity.ok(updateFacility);
    }

    //Code for Deleting facility
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteFacility(@PathVariable long id){
        FacilityEntity facilityEntity = facilityRepository.findById(id)
                .orElseThrow(()->new FacilityException("Facility Not found"));

        facilityRepository.delete(facilityEntity);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

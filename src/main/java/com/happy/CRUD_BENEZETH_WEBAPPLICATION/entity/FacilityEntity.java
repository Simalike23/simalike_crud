package com.happy.CRUD_BENEZETH_WEBAPPLICATION.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "facility_Info")
public class FacilityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "facilityId")
    int facilityId;
    @Column(name = "facilityName")
    String facilityName;
    @Column(name = "facilityLocation")
    String facilityLocation;
    @Column(name = "facilityContact")
    String facilityContact;
    @Column(name = "facilityWebsite")
    String facilityWebsite;
    @Column(name = "facilityCapacity")
    int facilityCapacity;

}

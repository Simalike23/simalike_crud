package com.happy.CRUD_BENEZETH_WEBAPPLICATION;

import com.happy.CRUD_BENEZETH_WEBAPPLICATION.entity.FacilityEntity;
import com.happy.CRUD_BENEZETH_WEBAPPLICATION.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudBenezethWebapplicationApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudBenezethWebapplicationApplication.class, args);
	}

	@Autowired
	private FacilityRepository facilityRepository;

	@Override
	public void run(String... args) throws Exception {
		FacilityEntity facilityEntity = new FacilityEntity();
		facilityEntity.setFacilityId(123);
		facilityEntity.setFacilityName("Maranatha Hospital");
		facilityEntity.setFacilityLocation("Mwanjelwa");
		facilityEntity.setFacilityContact("07623182742");
		facilityEntity.setFacilityCapacity(2000);
		facilityEntity.setFacilityWebsite("maranatha.com");
		facilityRepository.save(facilityEntity);
	}
}

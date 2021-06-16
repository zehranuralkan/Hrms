package com.example.Hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer>{
@Query("From JobAdvertisement where city.cityId=:cityId")
List<JobAdvertisement>getByCity_CityId(int cityId);
}

package com.pritesh.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.pritesh.api.entity.Weather;

public interface WeatherRepository extends Repository<Weather, String> {
	
	@Query("SELECT e.city FROM Weather e ORDER BY e.city")
	public List<String> findAllCities();

	public Weather findByCity(String city);

	@Query("SELECT e FROM Weather e where e.city=:city and e.date=:date")
	public Weather weatherByCityByPropertyDateNTime( @Param("city") String city,@Param("date") String date);

	public Weather findOne(String id);

	public Weather save(Weather weather); //update and insert

	public void delete(Weather weather);
}

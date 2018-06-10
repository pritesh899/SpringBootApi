package com.pritesh.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pritesh.api.entity.Weather;
import com.pritesh.api.exception.BadRequestException;
import com.pritesh.api.repository.WeatherRepository;
import com.pritesh.api.service.WeatherService;


@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private WeatherRepository weatherRespository;
	
	@Override
	@Transactional(readOnly=true)
	public List<String> findAllCities() {
		return weatherRespository.findAllCities();
	}

	@Override
	@Transactional(readOnly=true)
	public Weather WeatherByCity(String city) {
		Weather existing = weatherRespository.findByCity(city);
		if(existing == null)
		{
			throw new BadRequestException("City with "+city+" name does not exist");
		}
		return existing;
	}

	@Override
	@Transactional(readOnly=true)
	public String weatherByCityByProperty(String city, String property) {
		
		Weather existing = weatherRespository.findByCity(city);
		if(existing == null)
		{
			throw new BadRequestException("City with "+city+" name does not exist");
		}else{
			if (property.equals("wind"))
			{
				String wind = existing.getWind() + " "+ existing.getWindDirection() ; 
				return  wind;
			}
			else if (property.equals("humidity"))
			{
				String humidity = existing.getHumidity(); 
				return humidity;
			}

			else if (property.equals("temperature"))
			{
				String temperature = existing.getTemperature(); 
				return temperature;
			}
			else if (property.equals("sunrise"))
			{
				String sunrise = existing.getSunrise(); 
				return sunrise;
			}
			else if (property.equals("sunset"))
			{
				String sunset = existing.getSunset(); 
				return sunset;
			}
			else if (property.equals("pressure"))
			{
				String pressure = existing.getPressure(); 
				return pressure;
			}
			else if (property.equals("visibility"))
			{
				String visibility = existing.getVisibilty(); 
				return visibility;
			}
			else if (property.equals("feelsLike"))
			{
				String feelsLike = existing.getFeelsLike(); 
				return feelsLike;
			}

		}
		return "No data";
	}

	@Override
	@Transactional(readOnly=true)
	public Weather weatherByCityByPropertyDateNTime(String city, String date) {
		Weather existing = weatherRespository.weatherByCityByPropertyDateNTime(city,date);
		if(existing == null)
		{
			throw new BadRequestException("City with "+city+" name does not exist");
		}
		return existing;
	}

	@Override
	@Transactional
	public Weather createWeather(Weather weather) {
		return weatherRespository.save(weather);
	}

	@Transactional(readOnly=true)
	@Override
	public Weather updateWeather(String id, Weather weather) {
		Weather existing = weatherRespository.findOne(id);
		if(existing == null)
		{
			throw new BadRequestException("Weather with "+id+" does not exist");
		}
		return weatherRespository.save(weather);
	}

	@Override
	@Transactional
	public void deleteWeather(String id) {
		Weather existing = weatherRespository.findOne(id);
		if(existing == null)
		{
			throw new BadRequestException("Weather with "+id+" does not exist");
		}
	
		weatherRespository.delete(existing);
	}

	@Override
	@Transactional
	public Weather findOne(String id) {
		Weather existing = weatherRespository.findOne(id);
		if(existing == null)
		{
			throw new BadRequestException("Weather with "+id+" does not exist");
		}
		return existing;
	}

}

